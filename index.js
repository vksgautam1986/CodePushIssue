/**
 * @format
 */

import { AppRegistry, LogBox, Platform } from 'react-native';
import App from './App';
import { name as appName } from './app.json';
import KeyboardManager from 'react-native-keyboard-manager';

LogBox.ignoreAllLogs(null);

if (Platform.OS === 'ios') {
    KeyboardManager.setToolbarDoneBarButtonItemText("Done");
}

AppRegistry.registerComponent(appName, () => App);
