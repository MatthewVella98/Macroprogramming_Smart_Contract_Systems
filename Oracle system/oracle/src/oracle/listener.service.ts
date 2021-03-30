import { Injectable } from '@nestjs/common';
import { Observable, empty } from 'rxjs';
import { ChannelEventHub } from 'fabric-client';
import { ConvectorControllerClient, ControllerAdapter } from '@worldsibu/convector-core';
import { chaincode, channel, oracleEventToListen, l, externalURL } from '../env';

import { CCEvent } from './chaincode-event';
import { ConvectorControllers } from 'src/convector/controllers.interface';

import * as request from 'request-promise';


@Injectable()
export class OracleService {

    constructor(private cc: ConvectorControllers) {
        l('Initializing oracle service!');
        this.cc.initAdapter.then(() => {    // Initialising the adapter. 
            if (!this.cc.hub) {
                return empty();
            }
            l('Listening to oracle_request_data');
            
            // Pass the chaincode were we cant to listen for transaction, and the event name we're listening to. 
            // oracle-request0-data comes from env.ts
            Observable.create(observer => {
                this.cc.hub.registerChaincodeEvent(
                    chaincode,
                    oracleEventToListen,
                    (event, blockNumber, txId, txStatus) => observer.next({
                        event,
                        blockNumber,
                        txId,
                        txStatus,
                    }),
                    (err) => observer.error(err),
                    { filtered: false } as any,
                );
            }).subscribe(this.resolve.bind(this)); // This event is handled by this resolve function. 
        });
        // this.subscriber(EditType.ANIMAL_ONORIGINSCAN).subscribe(this.resolveAndSave.bind(this));
    }

    // Accessing the event data. Covnerting it to string. 
    async resolve(event) {
        // The data which is coming from the event. 
        const rawData =
            JSON.parse(event.event.payload.toString('utf8'));
        l('Got event requesting:');
        l(rawData);
        l('Querying external API for data');

        // A POST call to this external URL. - The mocakable.io external resource API. 
        const resStr = JSON.parse(await request({
            uri: externalURL,
            method: 'POST',
        }));

        l(resStr);

        // Call the callback method on the chaincode, and pass the data we get from the external API. 
        await this.cc.controller.__callback(rawData.oracleResponseCode, resStr.value);
        l('Querying external API for data');

    }

}
