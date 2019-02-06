/*
 * Copyright 2018 Fluence Labs Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

extern crate proc_macro;
mod parser;

use crate::parser::{InputTypeGenerator, ParsedType, ReturnTypeGenerator};
use proc_macro::TokenStream;
use quote::quote;
use syn::{parse::Error, parse_macro_input, ItemFn};

#[warn(clippy::redundant_closure_call)]
fn invoke_handler_impl(fn_item: &syn::ItemFn) -> proc_macro2::TokenStream {
    let ItemFn {
        constness,
        unsafety,
        abi,
        ident,
        decl,
        ..
    } = fn_item;

    if let Err(e) = (|| {
        if decl.inputs.len() != 1 {
            return Err(Error::new(
                decl.paren_token.span,
                "The principal module invocation handler has to have one input param",
            ));
        }
        if let Some(constness) = constness {
            return Err(Error::new(
                constness.span,
                "The principal module invocation handler has to don't be const",
            ));
        }
        if let Some(unsafety) = unsafety {
            return Err(Error::new(
                unsafety.span,
                "The principal module invocation handler has to don't be unsafe",
            ));
        }
        if let Some(abi) = abi {
            return Err(Error::new(
                abi.extern_token.span,
                "The principal module invocation handler has to don't have custom linkage",
            ));
        }
        if !decl.generics.params.is_empty() || decl.generics.where_clause.is_some() {
            return Err(Error::new(
                decl.fn_token.span,
                "The principal module invocation handler has to don't have generic params",
            ));
        }
        if let Some(variadic) = decl.variadic {
            return Err(Error::new(
                variadic.spans[0],
                "The principal module invocation handler has to don't be variadic",
            ));
        }
        Ok(())
    })() {
        return e.to_compile_error();
    }

    let input_type = ParsedType::from_fn_arg(decl.inputs.first().unwrap().into_value()).unwrap();
    let output_type = ParsedType::from_return_type(&decl.output).unwrap();

    let prolog = input_type.generate_fn_prolog();
    let epilog = output_type.generate_fn_epilog();

    let resulted_invoke = quote! {
        #fn_item

        #[no_mangle]
        pub unsafe fn invoke(ptr: *mut u8, len: usize) -> std::ptr::NonNull<u8> {
            #prolog

            let result = #ident(arg);

            #epilog
        }
    };

    resulted_invoke
}

#[proc_macro_attribute]
pub fn invocation_handler(_attr: TokenStream, input: TokenStream) -> TokenStream {
    let fn_item = parse_macro_input!(input as ItemFn);
    invoke_handler_impl(&fn_item).into()
}