Ext.define('GrupoBruce.model.EstadoEquipo', {
    extend: 'Ext.data.Model',
    alias: 'model.MestadoEquipo',
    
    idProperty: 'idEequipo',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idEequipo', type: 'int'},
        {name: 'situacion', type: 'boolean'}
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEstadoEquipo',
            read: 'estadosEquipo',
            update: 'uuEstadoEquipo',
            destroy: 'ddEstadoEquipo'
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
