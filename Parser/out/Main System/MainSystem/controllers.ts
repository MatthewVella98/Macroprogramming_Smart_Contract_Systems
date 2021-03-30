import { Request, Response } from 'express';
import { PropertyControllerBackEnd } from '../convector';
import { ParticipantControllerBackEnd } from '../convector';

export async function PropertyController_createProperty(req: Request, res: Response): Promise<void>{
    try {
         let params = req.body;
              res.status(200).send(await PropertyControllerBackend
                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));
    } catch(ex){
        console.log('Error post PropertyController_createProperty', ex.stack);
        res.status(500).send(ex)
    }

	   transactionMessage("CreateProperty Success!");
}

export async function PropertyController_updateForSale(req: Request, res: Response): Promise<void>{
    try {
         let params = req.body;
              res.status(200).send(await PropertyControllerBackend
                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));
    } catch(ex){
        console.log('Error post PropertyController_updateForSale', ex.stack);
        res.status(500).send(ex)
    }

	      
	      transactionMessage("updateForSale Success!");
}

export async function PropertyController_transferProperty(req: Request, res: Response): Promise<void>{
    try {
         let params = req.body;
              res.status(200).send(await PropertyControllerBackend
                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));
    } catch(ex){
        console.log('Error post PropertyController_transferProperty', ex.stack);
        res.status(500).send(ex)
    }

	  
  	transactionMessage("Transfer Property Success!");
}

export async function PropertyController_getProperty(req: Request, res: Response): Promise<void>{
    try {
         let params = req.body;
              res.status(200).send(await PropertyControllerBackend
                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));
    } catch(ex){
        console.log('Error post PropertyController_getProperty', ex.stack);
        res.status(500).send(ex)
    }

   
    	    transactionMessage("Get Property Success!");
}

export async function ParticipantController_register(req: Request, res: Response): Promise<void>{
    try {
         let params = req.body;
              res.status(200).send(await ParticipantControllerBackend
                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));
    } catch(ex){
        console.log('Error post ParticipantController_register', ex.stack);
        res.status(500).send(ex)
    }

	  
	  transactionMessage("Register Participant Success!");
}

export async function ParticipantController_get(req: Request, res: Response): Promise<void>{
    try {
         let params = req.body;
              res.status(200).send(await ParticipantControllerBackend
                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));
    } catch(ex){
        console.log('Error post ParticipantController_get', ex.stack);
        res.status(500).send(ex)
    }
 

	    transactionMessage("Get Participant Success!");
}

function transactionMessage(message: string) {

	       console.log(message); 
	   
}