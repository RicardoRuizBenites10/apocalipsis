Ext.define('GrupoBruce.model.ObraPintura', {
    extend: 'Ext.data.Model',
    alias: 'model.Mobrapintura',
    
    idProperty: 'idCdiseno',
    fields: [
        {name: 'colordiseno', type: 'string'},
        {name: 'fecha', type: 'date'},
        {name: 'idCdiseno', type: 'string'},
        {name: 'idObra', type: 'int'}
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiObraPintura',
            read: 'obraPinturas',
            update: 'uuObraPintura',
            destroy: 'ddObraPintura'
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
