Ext.define('GrupoBruce.model.Proveedor', {
    extend: 'Ext.data.Model',
    alias: 'model.Mproveedor',
    idProperty: 'idProveedor',
    fields: [
        { name: 'ccorriente1', type: 'string' },
        { name: 'ccorriente2', type: 'string' },
        { name: 'correo', type: 'string' },
        { name: 'direccion', type: 'string' },
        { name: 'idProveedor', type: 'string' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean' },
        { name: 'telefono', type: 'string' }
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiProveedor',
            read: 'proveedors',
            update: 'uuProveedor',
            destroy: 'ddProveedor'
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
