Ext.define('GrupoBruce.model.FormaPago', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idFpago', type: 'int' },
        { name: 'situacion', type: 'boolean' }

    ]
});
