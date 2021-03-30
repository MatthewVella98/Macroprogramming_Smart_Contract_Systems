import { Request, Response } from 'express';
import { PropertyControllerBackEnd } from '../convector';
import { ParticipantControllerBackEnd } from '../convector';


export async function PropertyController_createProperty(req: Request, res: Response): Promise<void>{
    try{
        let params = req.body;
            res.status(200).send(await PropertyControllerBackEnd
                .createProperty(params.id,params.propertyType,params.ownerID,params.price,params.isForSale));
            
    } catch(ex) {
        console.log('Error post PropertyController_createProperty', ex.stack);
        res.status(500).send(ex);
    }

    transactionMessage("createProperty Success!"); 
}
export async function PropertyController_updateForSale(req: Request, res: Response): Promise<void>{
    try{
        let params = req.body;
            res.status(200).send(await PropertyControllerBackEnd
                .updateForSale(params.id,params.isForSale));
            
    } catch(ex) {
        console.log('Error post PropertyController_updateForSale', ex.stack);
        res.status(500).send(ex);
    }

    transactionMessage("updateForSale Success!"); 
}
export async function PropertyController_transferProperty(req: Request, res: Response): Promise<void>{
    try{
        let params = req.body;
            res.status(200).send(await PropertyControllerBackEnd
                .transferProperty(params.id,params.to));
            
    } catch(ex) {
        console.log('Error post PropertyController_transferProperty', ex.stack);
        res.status(500).send(ex);
    }

    transactionMessage("transferProperty Success!"); 
}
export async function PropertyController_getProperty(req: Request, res: Response): Promise<void>{
    try{
        let params = req.params;
        res.status(200).send(await PropertyControllerBackEnd
            .getProperty(params.id));
        
    } catch(ex) {
        console.log('Error get PropertyController_getProperty', ex.stack);
        res.status(500).send(ex);
    }

    transactionMessage("getProperty Success!"); 
}
export async function ParticipantController_register(req: Request, res: Response): Promise<void>{
    try{
        let params = req.body;
            res.status(200).send(await ParticipantControllerBackEnd
                .register(params.id,params.name));
            
    } catch(ex) {
        console.log('Error post ParticipantController_register', ex.stack);
        res.status(500).send(ex);
    }

    transactionMessage("register Success!"); 
}
export async function ParticipantController_get(req: Request, res: Response): Promise<void>{
    try{
        let params = req.params;
        res.status(200).send(await ParticipantControllerBackEnd
            .get(params.id));
        
    } catch(ex) {
        console.log('Error get ParticipantController_get', ex.stack);
        res.status(500).send(ex);
    }

    transactionMessage("get Success!"); 
}

function transactionMessage(message:string){
    console.log(message); 
} 