import * as yup from 'yup';
import {
  Controller,
  ConvectorController,
  Invokable,
  Param
} from '@worldsibu/convector-core-controller';

import { Property } from './property.model';
import { Participant } from 'participant-cc';

@Controller('property')
export class PropertyController extends ConvectorController {
  
  @Invokable()
  public async createProperty(
    @Param(yup.string())
    id: string,
    @Param(yup.string())
    propertyType: string,
    @Param(yup.string())
    ownerID: string,
    @Param(yup.number())
    price: number,
    @Param(yup.boolean())
    isForSale:boolean
    // @Param(yup.string())
    // oracleResponseCode: string,

  ) {

    // Set an event. We pass the event name that we want to emit and some data
    // this.tx.stub.setEvent('oracle_request_data', { id, oracleResponseCode });

    let property = new Property(id);
    property.propertyType = propertyType;
    property.assetOwner = ownerID;
    property.isForSale = isForSale;
    // property.oracleResponseCode = oracleResponseCode; 
    property.price = price; 

     // Time must be deterministic for all peers - When the transaction was created.  
     // property.dateStartRequest = this.tx.stub.getTxDate().getTime();

    await property.save();
  }

  @Invokable()
  public async updateForSale( 
    @Param(yup.string())
    id: string,
    @Param(yup.boolean())
    isForSale: boolean
  ) {
    // Check if Property exists 
    let property = await Property.getOne(id);
    console.log('Property:');
    console.log(Property);
    if (!property || !property.id) {
      throw new Error(`Property with id ${id} does not exist`);
    }
    // Check if the Owner exists 
    const owner = await Participant.getOne(property.assetOwner);
    console.log('Property owner:');
    console.log(owner);

    if (!owner || !owner.id || !owner.identities) {
      throw new Error('Referenced owner participant does not exist in the ledger');
    }

    // If the Participant is the actual owner of the property, the property can be updated
    const ownerCurrentIdentity = owner.identities.filter(identity => identity.status === true)[0];
    if (ownerCurrentIdentity.fingerprint === this.sender) {
      console.log('Identity can update Property');
      property.isForSale = isForSale;
      await property.save();
    } else {
      throw new Error(`Identity ${this.sender} is not allowed to update Property just ${owner.name} ${ownerCurrentIdentity.fingerprint} can`);
    }
  }

  @Invokable()
  public async transferProperty(
    @Param(yup.string())
    id: string,
    @Param(yup.string())
    to: string,
  ){
    let property = await Property.getOne(id);
    
    // Property exists check
    if (!property || !property.id) {
      throw new Error(`Property with id ${id} does not exist`);
    }

    // Owner exists check 
    const owner = await Participant.getOne(property.assetOwner);
    if (!owner || !owner.id || !owner.identities) {
      throw new Error('Referenced owner participant does not exist in the ledger');
    }
    // Owner is Sender check
    const ownerCurrentIdentity = owner.identities.filter(identity => identity.status === true)[0];
    if (ownerCurrentIdentity.fingerprint !== this.sender) {
      throw new Error(`Identity ${this.sender} is not allowed to update Property just ${owner.name} ${ownerCurrentIdentity.fingerprint} can`);
    }

    // Property is for sale check 
    if(property.isForSale){
        property.assetOwner = to;
        await property.save();
      } else {
        throw new Error(`The Property with ID ${property.id} is not for sale.`); 
      }
  }

  @Invokable()
  public async getProperty(
    @Param(yup.string())
    id: string
  ) {
    return await Property.getOne(id);
  }

   // Send tracking code + response number. 
   @Invokable()
   public async __callback(
     @Param(yup.string())
     oracleRespondeCode: string,
     @Param(yup.number())
     response: number,
   ) {
     // Querying the model using the responseCode 
     if (!oracleRespondeCode) {
       throw new Error('missing [oracleRespondeCode]');
     }
     console.log('Callback received');
     const valueResponse = await Property.query(Property, {
       'selector': {
         'oracleResponseCode': oracleRespondeCode
       }
     });
 
     // Validation 
     if (!valueResponse || !valueResponse[0] || !valueResponse[0].id) {
       throw new Error('No registry can be updated');
     }
 
     // Updating the model. 
     const model = new Property(valueResponse[0]);
     model.price = response;
     model.oracleResponseCode = '';
     model.dateOracleResponse = this.tx.stub.getTxDate().getTime();
     await model.save();
     console.log('[price] set after oracle response');
   }
}