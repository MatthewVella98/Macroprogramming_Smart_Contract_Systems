import { ConvectorModel } from '@worldsibu/convector-core-model';
export declare class Property extends ConvectorModel<Property> {
    readonly type: string;
    propertyType: string;
    price: number;
    assetOwner: string;
    isForSale: boolean;
    oracleResponseCode: string;
    dateStartRequest: number;
    dateOracleResponse: number;
}
