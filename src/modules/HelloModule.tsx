import { NativeModules } from 'react-native';
const { HelloModule } = NativeModules;
interface HelloInterface {
    createHello(message: any): void;
}
export default HelloModule as HelloInterface;