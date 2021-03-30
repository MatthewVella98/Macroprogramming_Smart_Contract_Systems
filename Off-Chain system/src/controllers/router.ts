import * as express from 'express';

import { 
    PropertyController_createProperty_post,
    PropertyController_updateForSale_post,
    PropertyController_transferProperty_post,
    PropertyController_getProperty_get,
    ParticipantController_register_post,
    ParticipantController_get_get } from './controllers'

export default express.Router()
.post('/property/createProperty', PropertyController_createProperty_post)
.post('/property/updateForSale', PropertyController_updateForSale_post)
.post('/property/transferProperty', PropertyController_transferProperty_post)
.get('/property/getProperty/:id', PropertyController_getProperty_get)
.post('/participant/register', ParticipantController_register_post)
.get('/participant/get/:id', ParticipantController_get_get)
