import { ConvectorController } from '@worldsibu/convector-core-controller';
import { Property } from './property.model';
export declare class PropertyController extends ConvectorController {
    createProperty(id: string, propertyType: string, ownerID: string, price: number, isForSale: boolean): Promise<void>;
    updateForSale(id: string, isForSale: boolean): Promise<void>;
    transferProperty(id: string, to: string): Promise<void>;
    getProperty(id: string): Promise<Property>;
    __callback(oracleRespondeCode: string, response: number): Promise<void>;
}
