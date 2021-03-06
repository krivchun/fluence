import {StorageType} from "../fluence/deployable";
import {getWeb3Js} from "../fluence/contract";
import * as bs58 from "bs58";

export function cutId(id: string): string {
    if (id.startsWith('0x')) {
        return id.replace(/^(.{8}).+(.{4})$/, '$1...$2');
    } else {
        return id.replace(/^(.{4}).+(.{4})$/, '$1...$2');
    }
}

export function remove0x(hex: string): string {
    if (hex.startsWith("0x")) {
        return hex.slice(2);
    } else {
        return hex;
    }
}

export function storageToString32(s: StorageType): string {
    let hex = getWeb3Js().utils.fromDecimal(s.valueOf());
    return getWeb3Js().utils.padLeft(hex, 64, "")
}

export function toIpfsHash(h: string): string {
    let multiHeader = Buffer.from([0x12, 0x20]);
    let buf = Buffer.from(remove0x(h), 'hex');
    let multihash = Buffer.concat([multiHeader, buf]);
    return bs58.encode(multihash);
}

export function fromIpfsHash(h: string): string {
    let decoded = bs58.decode(h);
    let cropped = decoded.slice(2);
    return '0x' + cropped.toString('hex').toUpperCase();
}
