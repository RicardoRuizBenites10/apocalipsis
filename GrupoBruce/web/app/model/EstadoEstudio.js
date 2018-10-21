Ext.define('GrupoBruce.model.EstadoEstudio', {
    extend: 'Ext.data.Model',
    alias: 'model.MestadoEstudio',
    
    idProperty: 'idEestudio',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idEestudio', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create : 'insertEstadoEstudio',
            read: 'estadosEstudio',
            update: 'updateEstadoEstudio',
            destroy: 'deleteEstadoEstudio'
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
