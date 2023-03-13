/**
 * @format
 */

import { AppRegistry } from 'react-native';
import App from './src/App';
import { name as appName } from './app.json';


// export const sum = (a: number, b: number): number => {
//     const addition = a + b;
//     return addition;
// }

AppRegistry.registerComponent(appName, () => App);
