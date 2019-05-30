import * as React from "react";
import {connect} from "react-redux";
import {DeployableAppId, deployableAppIds, deployableApps} from "../../../fluence/deployable";
import {FluenceEntityType} from "../app";
import {Link} from "react-router-dom";

interface State {}

interface Props {
    entityType: FluenceEntityType,
    entityId: string
}

class FluenceMenu extends React.Component<Props, State> {

    render(): React.ReactNode {
        return (
            <section className="sidebar">
                <ul className="sidebar-menu" data-widget="tree">
                    {/*
                    <li className={(this.props.entityType == FluenceEntityType.DeployableApp ? 'active' : '') + ' treeview menu-open'}>
                        <a href="#">
                            <i className="fa fa-arrow-circle-up"></i> <span>Instant Deploy</span>
                            <span className="pull-right-container">
                                        <i className="fa fa-angle-left pull-right"></i>
                                    </span>
                        </a>
                        <ul className="treeview-menu" style={{ display: 'block' }}>
                            {deployableAppIds.map((id: DeployableAppId) => (
                                <li className={this.props.entityId == id ? 'active' : ''}>
                                    <Link to={`/deploy/${id}`}>
                                        <i className="fa fa-circle-o"></i> {deployableApps[id].name}
                                    </Link>
                                </li>
                            ))}
                        </ul>
                    </li>
                    */}
                    <li className={this.props.entityType == FluenceEntityType.DeployableApp ? 'active' : ''}>
                        <Link to={`/deploy`}>
                            <i className="fa fa-arrow-circle-up"></i><span>Instant Deploy</span>
                        </Link>
                    </li>
                    <li className={this.props.entityType == FluenceEntityType.App ? 'active' : ''}>
                        <Link to={`/app`}>
                            <i className="ion ion-ios-gear-outline"></i><span>Applications</span>
                        </Link>
                    </li>
                    <li className={this.props.entityType == FluenceEntityType.Node ? 'active' : ''}>
                        <Link to={`/node`}>
                            <i className="ion ion-android-laptop"></i><span>Nodes</span>
                        </Link>
                    </li>
                    <li className={this.props.entityType == FluenceEntityType.Account ? 'active' : ''}>
                        <Link to={`/account`}>
                            <i className="fa fa-user"></i><span>Account</span>
                        </Link>
                    </li>
                    <li>
                        <a href="https://fluence.dev" target="_blank">
                            <i className="fa fa-life-bouy"></i><span>Documentation</span> <i className="fa fa-external-link margin-r-5 pull-right"/>
                        </a>
                    </li>
                </ul>
            </section>
        );
    }
}

export default connect()(FluenceMenu);
