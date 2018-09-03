Ext.define('GrupoBruce.model.CargoContrato', {
    extend: 'Ext.data.Model',
    idProperty: 'cargoContratoIdId',
    fields: [
        { name: 'fecha', type: 'date' },
        { name: 'observacion', type: 'string' },
        { name: 'cargoContratoIdId', reference: 'GrupoBruce.model.CargoContratoId', unique: true },
        { name: 'contratoTrabajadorId', reference: 'GrupoBruce.model.ContratoTrabajador' },
        { name: 'cargoId', reference: 'GrupoBruce.model.Cargo', type: 'int' }
    ]
});
