import * as yup from 'yup';
import {
  ConvectorModel,
  Default,
  ReadOnly,
  Required,
  Validate
} from '@worldsibu/convector-core-model';

export class Property extends ConvectorModel<Property> {
  
  // Automatically generated by Convector for each model
  @ReadOnly()
  @Required() 
  public readonly type = 'io.worldsibu.property';

  /* Our Types  */

  @Required() 
  @Validate(yup.string())
  public propertyType: string;
  
  @ReadOnly() @Required() @Validate(yup.number())
  public price: number; 
 
  @Required()
  @Validate(yup.string())
  // Reference to a participant id
  public assetOwner: string;

  @Required() @Validate(yup.boolean())
  public isForSale: boolean; 

  // Unique value to avoid exploit the __callback endpoint
  @Validate(yup.string())
  public oracleResponseCode: string;

  // Date when the tx is created
  @Validate(yup.number())
  public dateStartRequest: number;
  
  // Date when the oracle responds
  @Validate(yup.number())
  public dateOracleResponse: number;
}