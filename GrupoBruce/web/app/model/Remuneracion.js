Ext.define('GrupoBruce.model.Remuneracion', {
    extend: 'Ext.data.Model',
    
    idProperty: 'remuneracionIdId',
    fields: [
        { name: 'fecha', type: 'date' },
        { name: 'monto', type: 'float' },
        { name: 'remuneracionIdId', reference: 'GrupoBruce.model.RemuneracionId', unique: true },
        { name: 'contratoTrabajadorId', reference: 'GrupoBruce.model.ContratoTrabajador', type: 'string' }
    ]
});
