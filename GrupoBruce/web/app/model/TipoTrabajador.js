Ext.define('GrupoBruce.model.TipoTrabajador', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoTrabajador',
    
    idProperty: 'idTtrabajador',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTtrabajador', type: 'int' },
        { name: 'hasctacts', type: 'boolean' },
        { name: 'hasrpensionario', type: 'boolean' },
        { name: 'seguro', type: 'float' },
        { name: 'essalud', type: 'float' },
        { name: 'vida', type: 'float' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    identifier: 'sequential',    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTipoTrabajador',
            read: 'tipoTrabajadorBySituacion',
            update: 'uuTipoTrabajador',
            destroy: 'ddTipoTrabajador'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
