import * as React from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import ReactModal from 'react-modal';
import { match, withRouter } from 'react-router';
import { Action } from 'redux';
import { History } from 'history';
import {contractAddress, dashboardContract, isMetamaskActive} from '../../../fluence/contract';
import {account as demoAddress} from '../../../constants';
import {App, AppId, AppRef, getAppRefs, getNodeRefs, Node, NodeRef} from '../../../fluence';
import {DeployableAppId, deployableAppIds, deployableApps} from "../../../fluence/deployable";
import { cutId } from '../../../utils';
import FluenceApp from '../fluence-app';
import FluenceNode from '../fluence-node';
import FluenceDeployableApp from '../fluence-deployable-app';
import FluenceAppsList from '../fluence-apps-list';
import FluenceNodesList from '../fluence-nodes-list';
import FluenceAppSnippet from '../fluence-app-snippet';
import FluenceDeployList from '../fluence-deploy-list';
import FluenceMenu from '../fluence-menu';
import FluenceList from '../fluence-list';
//import { restoreDeployed, resetDeployed } from '../../actions';
import * as fluence from 'fluence';

import 'bootstrap/dist/css/bootstrap.css';
import 'font-awesome/css/font-awesome.css';
//import 'ionicons/dist/css/ionicons.css'; /* different version, lack of icons */
import 'admin-lte/bower_components/Ionicons/css/ionicons.min.css';
import 'admin-lte/dist/css/AdminLTE.css';
import 'admin-lte/dist/css/skins/skin-blue.css';
import './style.css';

export enum FluenceEntityType {
    None = -1,
    Stub = 'stub',
    App  = 'app',
    Node = 'node',
    DeployableApp = 'deploy',
    Account = 'account',
}

interface State {}

interface UrlParams {
    entityType: string;
    entityId: string;
    entitySubType: string;
}

interface Props {
    match: match<UrlParams>;
    loading: boolean;
}

class DashboardApp extends React.Component<Props, State> {
    state: State = {};

    componentDidMount(): void {
        // Make fluence available from browser console
        (window as any).fluence = fluence;

        //getAppRefs(dashboardContract).then(apps => console.log(apps)).catch(err => console.log(err));
        //getNodeRefs(dashboardContract).then(nodes => console.log(nodes)).catch(err => console.log(err));

        //const deployedApp = getDeployedApp();
        //if (deployedApp && this.props.match.path == '/') {
            //this.props.restoreDeployed(deployedApp.deployedAppId, deployedApp.deployedAppTypeId, this.props.history);
        //}
    }

    renderEntity(entityType: FluenceEntityType, entityId: string): React.ReactNode | React.ReactNode[] {
        if(entityType && entityId) {
            switch (entityType) {
                case FluenceEntityType.App: {
                    return [
                        <div className="col-md-6 col-xs-12">
                            <FluenceApp appId={entityId}/>
                        </div>,
                        <div className="col-md-6 col-xs-12">
                            <FluenceAppSnippet appId={entityId}/>
                        </div>,
                    ];
                }
                case FluenceEntityType.Node: {
                    return (
                        <div className="col-md-6 col-xs-12">
                            <FluenceNode nodeId={entityId}/>
                        </div>
                    );
                }
                case FluenceEntityType.DeployableApp: {
                    return (
                        <div className="col-md-6 col-xs-12">
                            <FluenceDeployableApp id={entityId}/>
                        </div>
                    );
                }
                case FluenceEntityType.Account: {
                    return this.renderEntity(this.props.match.params.entitySubType as FluenceEntityType, entityId);
                }
            }
        }

        return (
            <div className="col-md-6 col-xs-12">
                <div className="box box-primary">
                    <div className="box-header with-border">
                        <h3 className="box-title">Fluence Network</h3>
                    </div>
                    <div className="box-body">
                        <p>Fluence is a permissionless decentralized database platform, trustless and efficient.
                            With Fluence, you will be able to deploy an SQL/NoSQL database with just a few clicks!</p>

                        <p>Fluence Network is a work in progress and is currently in the devnet state. Feel free to play
                            with it and build demo DApps on top of your deployed database, but keep in mind that the API
                            is not stabilized yet and might change in the future.</p>

                        <p>If you have any questions or need help with your setup, please reach out to us at <a
                            href="https://discord.gg/AjfbDKQ">Discord</a>!
                            You can also take a look at the Fluence documentation.</p>
                    </div>
                </div>
            </div>
        );
    }

    renderSectionLabel(entityType: FluenceEntityType): string {
        switch (entityType) {
            case FluenceEntityType.App: {
                return 'Applications';
            }
            case FluenceEntityType.Node: {
                return 'Nodes';
            }
            case FluenceEntityType.DeployableApp: {
                return 'Deploy';
            }
            case FluenceEntityType.Account: {
                return 'Account';
            }
            default: {
                return 'Network status';
            }
        }
    }

    render(): React.ReactNode {
        return (
            <div className="wrapper">
                <header className="main-header">
                    <nav className="navbar navbar-static-top navbar-fluence-background">

                        <Link to="/" className="logo">
                            <span className="logo-lg">Fluence network dashboard</span>
                        </Link>

                        <div className="navbar-custom-menu">
                            <ul className="nav navbar-nav">
                                <li style={{display: isMetamaskActive() ? 'none' : 'block'}}>
                                    <span className="fluence-header-label">Working in <span className="error">DEMO MODE</span></span>
                                </li>
                                <li>
                                    <span className="fluence-header-label">Network contract: <a
                                        href={'https://rinkeby.etherscan.io/address/' + contractAddress}
                                        title={contractAddress} target="_blank">{cutId(contractAddress)}</a></span>
                                </li>
                                <li style={{visibility: this.props.loading ? 'visible' : 'hidden'}}>
                                    <a href="#"><i className="fa fa-refresh fa-spin"></i></a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </header>

                <div className="content-middle">
                    <aside className="main-sidebar">
                        <FluenceMenu entityType={this.props.match.params.entityType} entityId={this.props.match.params.entityId}/>
                        <FluenceList entityType={this.props.match.params.entityType} entityId={this.props.match.params.entityId}/>
                    </aside>

                    <div className="content-wrapper">
                        <section className="content-header">
                            <h1>{this.renderSectionLabel(this.props.match.params.entityType as FluenceEntityType)}</h1>
                        </section>

                        <section className="content">
                            <div className="row">
                                {this.renderEntity(this.props.match.params.entityType as FluenceEntityType, this.props.match.params.entityId)}
                            </div>
                        </section>
                    </div>
                </div>

                <footer className="main-footer">
                    <strong><a href="http://fluence.network/">Fluence Labs&nbsp;&nbsp;</a>|&nbsp;&nbsp;</strong>
                    <strong><a href="https://discordapp.com/invite/AjfbDKQ">Discord&nbsp;&nbsp;</a>|&nbsp;&nbsp;</strong>
                    <strong><a href="https://github.com/fluencelabs/fluence">GitHub&nbsp;&nbsp;</a>|&nbsp;&nbsp;</strong>
                    <strong><a href="https://github.com/fluencelabs/tutorials">Tutorials&nbsp;&nbsp;</a>|&nbsp;&nbsp;</strong>
                    <strong><a href="https://fluence.network/docs">Documentation</a></strong>
                </footer>

                <ReactModal
                    isOpen={false}
                    onAfterOpen={() => {}}
                    onRequestClose={() => {}}
                    contentLabel="Example Modal"
                >
                    <div className="modal-content">
                        <div className="modal-header">
                            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span></button>
                            <h4 className="modal-title">Default Modal</h4>
                        </div>
                        <div className="modal-body">
                            <p>One fine body…</p>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-default pull-left" data-dismiss="modal">Close
                            </button>
                            <button type="button" className="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </ReactModal>
            </div>
        );
    }
}

const mapStateToProps = (state: any) => ({
    loading: state.loading.isLoading,
});

const mapDispatchToProps = {};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(DashboardApp));
