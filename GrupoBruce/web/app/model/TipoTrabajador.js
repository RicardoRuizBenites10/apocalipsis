Ext.define('GrupoBruce.model.TipoTrabajador', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoTrabajador',
    
    idProperty: 'idTtrabajador',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTtrabajador', type: 'int' },
        { name: 'hasctacts', type: 'boolean' },
        { name: 'hasrpensionario', type: 'boolean' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api:{
            read: 'tipoTrabajadorBySituacion',
            create: 'iiTipoTrabajador',
            updte: 'uuTipoTrabajador',
            delete: 'ddTipoTrabajador'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});
