import { ConvectorController } from '@worldsibu/convector-core';
import { Participant } from './participant.model';
import { ClientIdentity } from 'fabric-shim';
export declare class ParticipantController extends ConvectorController {
    readonly fullIdentity: ClientIdentity;
    register(id: string, name: string): Promise<void>;
    get(id: string): Promise<Participant>;
}
