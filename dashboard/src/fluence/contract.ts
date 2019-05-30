import Web3 from "web3";
import {Network} from "../../types/web3-contracts/Network";
import NetworkABI from '../abi/Network.json';
import {Dashboard} from "../../types/web3-contracts/Dashboard";
import DashboardABI from '../abi/Dashboard.json';
import {dashboardContractAddress, defaultContractAddress, fluenceNodeAddr, rootTagId, account as demoAddress} from '../constants';

function getContract(address: string, abi: any, web3js: any) {
    return new web3js.eth.Contract(abi, address);
}

const search = (window as any).location.search;
const urlParams = new URLSearchParams(search);
const contractFromUrl = urlParams.get('contract');

const rootElement = document.getElementById(rootTagId);
const contractFromTag = rootElement ? rootElement.getAttribute('data-contract') : null;

export const contractAddress: string = contractFromUrl ? contractFromUrl : (contractFromTag ? contractFromTag : defaultContractAddress);

const injectedWeb3 = (window as any).web3;

let isMetamaskProviderActive = false;
let provider = null;
if (typeof injectedWeb3 !== 'undefined') {
    if (injectedWeb3.currentProvider.networkVersion == '4' && injectedWeb3.currentProvider.selectedAddress) { // Rinkeby network
        provider = injectedWeb3.currentProvider;
        isMetamaskProviderActive = true;
    }
}

if (!provider) {
    provider = new Web3.providers.HttpProvider(fluenceNodeAddr);
    isMetamaskProviderActive = false;
}

export function getUserAddress(): string {
    if (typeof injectedWeb3 !== 'undefined') {
        if (injectedWeb3.currentProvider.networkVersion == '4' && injectedWeb3.currentProvider.selectedAddress) { // Rinkeby network
            return injectedWeb3.currentProvider.selectedAddress;
        }
    }
    return demoAddress;
}

export function isMetamaskActive(): boolean {
    return isMetamaskProviderActive;
}

export const web3js = new Web3(provider);
const contract = getContract(contractAddress, NetworkABI, web3js) as Network;

export const dashboardContract = getContract(dashboardContractAddress, DashboardABI, web3js) as Dashboard;

export default contract;

