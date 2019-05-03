Ext.define('GrupoBruce.model.ChasisProveedor', {
    extend: 'Ext.data.Model',
    alias: 'model.Mchasisproveedor',
    idProperty: 'idChapro',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idChapro', type: 'string'},
        {name: 'situacion', type: 'boolean'}
    ],

    identifier: {
        type: 'sequential',
        prefix: '00'
    },

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiChasisProveedor',
            read: 'chasisProveedors',
            update: 'uuChasisProveedor',
            destroy: 'ddChasisProveedor'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
