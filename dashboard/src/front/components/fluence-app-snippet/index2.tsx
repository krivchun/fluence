import * as React from "react";
import {connect} from "react-redux";

interface State {}

interface Props {}

class FluenceAppSnippet extends React.Component<Props, State> {

    render(): React.ReactNode {
        return (
            <div className="box box-primary">
                <div className="box-header with-border">
                    <h3 className="box-title">App snippet</h3>
                </div>
                <div className="box-body">
                    <p>Snippet for this app</p>
                </div>
            </div>
        );
    }
}

export default connect()(FluenceAppSnippet);
