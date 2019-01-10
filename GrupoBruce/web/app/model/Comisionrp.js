Ext.define('GrupoBruce.model.Comisionrp', {
    extend: 'Ext.data.Model',
    alias: 'model.Mcomisionrp',

    idProperty: 'idComisionrp',
    fields: [
        {name: 'comision', type: 'float'},
        {name: 'descripcion', type: 'string'},
        {name: 'fondo', type: 'float'},
        {name: 'idComisionrp', type: 'int'},
        {name: 'seguro', type: 'float'},
        {name: 'idRpensionario', type: 'string'}
    ],

    identifier: {
        type: 'sequential'
    },

    proxy: {
        type: 'ajax',
        api: {
            read: 'comisionrps',
            create: 'iiComisionrp',
            update: 'uuComisionrp',
            destroy: 'ddComisionrp'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
