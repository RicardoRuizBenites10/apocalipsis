Ext.define('GrupoBruce.model.EntidadFinanciera', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'idEfinanciera', type: 'int' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean' }

    ]
});
