Ext.define('GrupoBruce.model.EntidadFinanciera', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idEfinanciera',
    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'idEfinanciera', type: 'string' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ]
});
