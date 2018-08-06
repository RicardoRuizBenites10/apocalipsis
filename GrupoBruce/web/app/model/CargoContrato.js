Ext.define('GrupoBruce.model.CargoContrato', {
    extend: 'Ext.data.Model',
    idProperty: 'cargoContratoIdId',
    fields: [
        { name: 'fecha', type: 'date' },
        { name: 'observacion', type: 'string' },
        { name: 'cargoContratoIdId', reference: 'CargoContrato', unique: true },
        { name: 'contratoTrabajadorId', reference: 'ContratoTrabajador'},
        { name: 'cargoId', reference: 'Cargo'}
    ]
});
