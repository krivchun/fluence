import {getNodeRefs, NodeRef} from '../../../fluence';
import { dashboardContract } from '../../../fluence/contract';
import { Dispatch, Action } from 'redux';
import {DELETE_NODE} from "./delete-node";

export const GET_NODES_REFS_RECEIVE = 'GET_NODES_REFS_RECEIVE';

export const retrieveNodeRefs = () => {
    return async (dispatch: Dispatch): Promise<Action> => {
        const nodeRefs = await getNodeRefs(dashboardContract);
        return dispatch({
            type: GET_NODES_REFS_RECEIVE,
            nodeRefs,
        });
    };
};

/*
 * Reducer
 */
export default (state: NodeRef[] = [], action: any) => {
    switch (action.type) {
        case GET_NODES_REFS_RECEIVE: {
            return action.nodeRefs;
        }
        case DELETE_NODE: {
            return state.filter(nodeRef => nodeRef.node_id != action.nodeId);
        }
        default: {
            return state;
        }
    }
};
