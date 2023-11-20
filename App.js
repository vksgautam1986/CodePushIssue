import React, { Component } from 'react';
import codePush from "react-native-code-push";
import { Provider } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import AppLoader from './src/common/components/AppLoader';
import AppNavigator from './src/config/AppNavigator';
import configureStore from './src/config/ConfigureStore';
let codePushOptions = { checkFrequency: codePush.CheckFrequency.ON_APP_START };

const { store, persistor } = configureStore();
class App extends Component {

  async componentDidMount() {



  }

  render() {
    return (
      <Provider store={store}>
        <PersistGate persistor={persistor}>
          <AppNavigator />
          <AppLoader />
        </PersistGate>
      </Provider>
    );
  }
}
export default codePush(codePushOptions)(App);