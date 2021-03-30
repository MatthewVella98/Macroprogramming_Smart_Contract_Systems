import * as yup from 'yup':
import {
  ConvectorModel,
  Default,
  ReadOnly,
  Required,
  Validate
} from '@worldsibu/convector-core-model'; 

export class Property extends ConvectorModel<Property> {

  @ReadOnly() @Required() public readonly type = 'io.worldsibu.property';

  
  public propertyType: string;

  
  public assetOwner: string;

  
  public isForSale: boolean;

  @ReadOnly() @Required() @Validate(yup.number())
  public price: number;

}