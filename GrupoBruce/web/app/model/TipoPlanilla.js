Ext.define('GrupoBruce.model.TipoPlanilla', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoPlanilla',
    
    idProperty: 'idTipo',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTipo', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTipoPlanilla',
            read: 'tiposPlanilla',
            update: 'uuTipoPlanilla',
            destroy: 'ddTipoPlanilla'
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
