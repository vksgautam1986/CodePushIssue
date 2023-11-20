import React from "react";

import NetInfo from "@react-native-community/netinfo";
import { SafeAreaView } from "react-native";
import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import { networkReachability } from "../redux/common/actions";
import Navigation from "./Navigation";
import colors from "../utils/colors";

class AppNavigator extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isSyncRunning: false,
        }
    }

    componentDidMount() {
        NetInfo.fetch().then(state => {
            //first time launch 
            this.updateNetworkState(state);
        });
        // Subscribe
        this.unsubscribe = NetInfo.addEventListener(state => {
            this.updateNetworkState(state);
        });
    }

    updateNetworkState = (state) => {
        let isConnected = state.isConnected;
        if (state && state.type && state.type == 'cellular') {
            if (state && state.details && state.details.cellularGeneration
                && (state.details.cellularGeneration == '2g')) {//|| state.details.cellularGeneration == '3g'
                isConnected = false;
            }
        }
        this.props.networkReachability(isConnected);
    }

    componentWillUnmount() {
        this.unsubscribe();
    }

    render() {
        return (
            <SafeAreaView style={{ flex: 1, backgroundColor: colors.appColor }}>
              <View style={{flex:1}}><Text style={{marginTop:30,}}>Test View</Text> </View>
            </SafeAreaView>
        );
    }

    loadNavation = (nav) => {
        this.navigator = nav;
    }
}

function mapStateToProps(state) {
    return {
        Auth: state.auth,
    };
}

function mapDispatchToProps(dispatch) {
    return {
        networkReachability: bindActionCreators(networkReachability, dispatch),
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(AppNavigator);