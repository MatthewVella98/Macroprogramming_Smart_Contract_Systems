"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var tslib_1 = require("tslib");
var yup = require("yup");
var convector_core_controller_1 = require("@worldsibu/convector-core-controller");
var property_model_1 = require("./property.model");
var participant_cc_1 = require("participant-cc");
var PropertyController = (function (_super) {
    tslib_1.__extends(PropertyController, _super);
    function PropertyController() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    PropertyController.prototype.createProperty = function (id, propertyType, ownerID, price, isForSale) {
        return tslib_1.__awaiter(this, void 0, void 0, function () {
            var property;
            return tslib_1.__generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        property = new property_model_1.Property(id);
                        property.propertyType = propertyType;
                        property.assetOwner = ownerID;
                        property.isForSale = isForSale;
                        property.price = price;
                        return [4, property.save()];
                    case 1:
                        _a.sent();
                        return [2];
                }
            });
        });
    };
    PropertyController.prototype.updateForSale = function (id, isForSale) {
        return tslib_1.__awaiter(this, void 0, void 0, function () {
            var property, owner, ownerCurrentIdentity;
            return tslib_1.__generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4, property_model_1.Property.getOne(id)];
                    case 1:
                        property = _a.sent();
                        console.log('Property:');
                        console.log(property_model_1.Property);
                        if (!property || !property.id) {
                            throw new Error("Property with id " + id + " does not exist");
                        }
                        return [4, participant_cc_1.Participant.getOne(property.assetOwner)];
                    case 2:
                        owner = _a.sent();
                        console.log('Property owner:');
                        console.log(owner);
                        if (!owner || !owner.id || !owner.identities) {
                            throw new Error('Referenced owner participant does not exist in the ledger');
                        }
                        ownerCurrentIdentity = owner.identities.filter(function (identity) { return identity.status === true; })[0];
                        if (!(ownerCurrentIdentity.fingerprint === this.sender)) return [3, 4];
                        console.log('Identity can update Property');
                        property.isForSale = isForSale;
                        return [4, property.save()];
                    case 3:
                        _a.sent();
                        return [3, 5];
                    case 4: throw new Error("Identity " + this.sender + " is not allowed to update Property just " + owner.name + " " + ownerCurrentIdentity.fingerprint + " can");
                    case 5: return [2];
                }
            });
        });
    };
    PropertyController.prototype.transferProperty = function (id, to) {
        return tslib_1.__awaiter(this, void 0, void 0, function () {
            var property, owner, ownerCurrentIdentity;
            return tslib_1.__generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4, property_model_1.Property.getOne(id)];
                    case 1:
                        property = _a.sent();
                        if (!property || !property.id) {
                            throw new Error("Property with id " + id + " does not exist");
                        }
                        return [4, participant_cc_1.Participant.getOne(property.assetOwner)];
                    case 2:
                        owner = _a.sent();
                        if (!owner || !owner.id || !owner.identities) {
                            throw new Error('Referenced owner participant does not exist in the ledger');
                        }
                        ownerCurrentIdentity = owner.identities.filter(function (identity) { return identity.status === true; })[0];
                        if (ownerCurrentIdentity.fingerprint !== this.sender) {
                            throw new Error("Identity " + this.sender + " is not allowed to update Property just " + owner.name + " " + ownerCurrentIdentity.fingerprint + " can");
                        }
                        if (!property.isForSale) return [3, 4];
                        property.assetOwner = to;
                        return [4, property.save()];
                    case 3:
                        _a.sent();
                        return [3, 5];
                    case 4: throw new Error("The Property with ID " + property.id + " is not for sale.");
                    case 5: return [2];
                }
            });
        });
    };
    PropertyController.prototype.getProperty = function (id) {
        return tslib_1.__awaiter(this, void 0, void 0, function () {
            return tslib_1.__generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4, property_model_1.Property.getOne(id)];
                    case 1: return [2, _a.sent()];
                }
            });
        });
    };
    PropertyController.prototype.__callback = function (oracleRespondeCode, response) {
        return tslib_1.__awaiter(this, void 0, void 0, function () {
            var valueResponse, model;
            return tslib_1.__generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (!oracleRespondeCode) {
                            throw new Error('missing [oracleRespondeCode]');
                        }
                        console.log('Callback received');
                        return [4, property_model_1.Property.query(property_model_1.Property, {
                                'selector': {
                                    'oracleResponseCode': oracleRespondeCode
                                }
                            })];
                    case 1:
                        valueResponse = _a.sent();
                        if (!valueResponse || !valueResponse[0] || !valueResponse[0].id) {
                            throw new Error('No registry can be updated');
                        }
                        model = new property_model_1.Property(valueResponse[0]);
                        model.price = response;
                        model.oracleResponseCode = '';
                        model.dateOracleResponse = this.tx.stub.getTxDate().getTime();
                        return [4, model.save()];
                    case 2:
                        _a.sent();
                        console.log('[price] set after oracle response');
                        return [2];
                }
            });
        });
    };
    tslib_1.__decorate([
        convector_core_controller_1.Invokable(),
        tslib_1.__param(0, convector_core_controller_1.Param(yup.string())),
        tslib_1.__param(1, convector_core_controller_1.Param(yup.string())),
        tslib_1.__param(2, convector_core_controller_1.Param(yup.string())),
        tslib_1.__param(3, convector_core_controller_1.Param(yup.number())),
        tslib_1.__param(4, convector_core_controller_1.Param(yup.boolean()))
    ], PropertyController.prototype, "createProperty", null);
    tslib_1.__decorate([
        convector_core_controller_1.Invokable(),
        tslib_1.__param(0, convector_core_controller_1.Param(yup.string())),
        tslib_1.__param(1, convector_core_controller_1.Param(yup.boolean()))
    ], PropertyController.prototype, "updateForSale", null);
    tslib_1.__decorate([
        convector_core_controller_1.Invokable(),
        tslib_1.__param(0, convector_core_controller_1.Param(yup.string())),
        tslib_1.__param(1, convector_core_controller_1.Param(yup.string()))
    ], PropertyController.prototype, "transferProperty", null);
    tslib_1.__decorate([
        convector_core_controller_1.Invokable(),
        tslib_1.__param(0, convector_core_controller_1.Param(yup.string()))
    ], PropertyController.prototype, "getProperty", null);
    tslib_1.__decorate([
        convector_core_controller_1.Invokable(),
        tslib_1.__param(0, convector_core_controller_1.Param(yup.string())),
        tslib_1.__param(1, convector_core_controller_1.Param(yup.number()))
    ], PropertyController.prototype, "__callback", null);
    PropertyController = tslib_1.__decorate([
        convector_core_controller_1.Controller('property')
    ], PropertyController);
    return PropertyController;
}(convector_core_controller_1.ConvectorController));
exports.PropertyController = PropertyController;
//# sourceMappingURL=property.controller.js.map