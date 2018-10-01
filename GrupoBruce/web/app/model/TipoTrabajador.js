Ext.define('GrupoBruce.model.TipoTrabajador', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoTrabajador',
    
    idProperty: 'idTtrabajador',
    fields: [
        { name: 'codigo', type: 'string' },
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
            create: 'insertTipoTrabajador',
            updte: 'updateTipoTrabajador',
            delete: 'deleteTipoTrabajador'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});
