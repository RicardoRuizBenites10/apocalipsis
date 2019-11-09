Ext.define('GrupoBruce.model.ObraTipo', {
    extend: 'Ext.data.Model',
    alias: 'model.Mobratipo',
    
    idProperty: 'idObrtip',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idObrtip', type: 'string'},
        {name: 'situacion', type: 'boolean'}
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiObraTipo',
            read: 'obratipos',
            update: 'uuObraTipo',
            destroy: 'ddObraTipo'
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
