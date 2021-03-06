"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var tslib_1 = require("tslib");
var yup = require("yup");
var convector_core_model_1 = require("@worldsibu/convector-core-model");
var Property = (function (_super) {
    tslib_1.__extends(Property, _super);
    function Property() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.type = 'io.worldsibu.property';
        return _this;
    }
    tslib_1.__decorate([
        convector_core_model_1.ReadOnly(),
        convector_core_model_1.Required()
    ], Property.prototype, "type", void 0);
    tslib_1.__decorate([
        convector_core_model_1.Required(),
        convector_core_model_1.Validate(yup.string())
    ], Property.prototype, "propertyType", void 0);
    tslib_1.__decorate([
        convector_core_model_1.ReadOnly(), convector_core_model_1.Required(), convector_core_model_1.Validate(yup.number())
    ], Property.prototype, "price", void 0);
    tslib_1.__decorate([
        convector_core_model_1.Required(),
        convector_core_model_1.Validate(yup.string())
    ], Property.prototype, "assetOwner", void 0);
    tslib_1.__decorate([
        convector_core_model_1.Required(), convector_core_model_1.Validate(yup.boolean())
    ], Property.prototype, "isForSale", void 0);
    tslib_1.__decorate([
        convector_core_model_1.Validate(yup.string())
    ], Property.prototype, "oracleResponseCode", void 0);
    tslib_1.__decorate([
        convector_core_model_1.Validate(yup.number())
    ], Property.prototype, "dateStartRequest", void 0);
    tslib_1.__decorate([
        convector_core_model_1.Validate(yup.number())
    ], Property.prototype, "dateOracleResponse", void 0);
    return Property;
}(convector_core_model_1.ConvectorModel));
exports.Property = Property;
//# sourceMappingURL=property.model.js.map