Ext.define('GrupoBruce.model.TipoVacacion', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoVacacion',

    idProperty: 'idTVacacion',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTVacacion', type: 'int' },
        { name: 'pagar', type: 'boolean' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'insertTipoVacacion',
            read: 'tiposVacacion',
            update: 'updateTipoVacacion',
            destroy: 'deleteTipoVacacion'
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
