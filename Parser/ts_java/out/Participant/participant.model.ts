import * as yup from 'yup';
import {
  ConvectorModel,
  ReadOnly,
  Required,
  Validate,
  FlatConvectorModel
} from '@worldsibu/convector-core'; 

export class Participant extends ConvectorModel<Participant> {

  @ReadOnly() @Required() public readonly type = 'io.worldsibu.examples.participant';

  
  public name: string;

  
  public msp: string;

  
  public identities: Array<FlatConvectorModel<x509Identities>>;

}

export class x509Identities extends ConvectorModel<x509Identities> {

  @ReadOnly() public readonly type = 'io.worldsibu.examples.x509identity';

  
  public status: boolean;

  
  public fingerprint: string;

}