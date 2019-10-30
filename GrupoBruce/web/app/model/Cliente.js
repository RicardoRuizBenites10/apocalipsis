Ext.define('GrupoBruce.model.Cliente', {
    extend: 'Ext.data.Model',
    idProperty: 'idCliente',
    fields: [
        {name: 'correo', type: 'string'},
        {name: 'direccion', type: 'string'},
        {name: 'idCliente', type: 'string'},
        {name: 'nombre', type: 'string'},
        {name: 'telefono', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiCliente',
            read: 'clientes',
            update: 'uuCliente',
            destroy: 'ddCliente'
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
