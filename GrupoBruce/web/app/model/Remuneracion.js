Ext.define('GrupoBruce.model.Remuneracion', {
    extend: 'Ext.data.Model',
    idProperty: 'remuneracionIdId',
    fields: [
        { name: 'fecha', type: 'date' },
        { name: 'monto', type: 'float' },
        { name: 'remuneracionIdId', reference: 'RemuneracionId', unique: true },
        { name: 'contratoTrabajadorId', reference: 'ContratoTrabajador' }
    ]
});
