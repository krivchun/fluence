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

//! Rust SDK for writing applications for Fluence.
#![doc(html_root_url = "https://docs.rs/fluence/0.0.7")]
#![feature(allocator_api)]

extern crate core;

pub mod memory;

#[cfg(any(
    feature = "wasm_logger_info",
    feature = "wasm_logger_warn",
    feature = "wasm_logger_error"
))]
pub mod logger;

#[cfg(feature = "export_allocator")]
pub mod export_allocator;