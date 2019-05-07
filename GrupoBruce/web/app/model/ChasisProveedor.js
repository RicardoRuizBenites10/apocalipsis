Ext.define('GrupoBruce.model.ChasisProveedor', {
    extend: 'Ext.data.Model',
    alias: 'model.Mchasisproveedor',
    idProperty: 'idChapro',
    fields: [
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idChapro', type: 'string'},
        {name: 'nombre', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
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
