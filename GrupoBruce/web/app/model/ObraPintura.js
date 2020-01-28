Ext.define('GrupoBruce.model.ObraPintura', {
    extend: 'Ext.data.Model',
    alias: 'model.Mobrapintura',
    
    idProperty: 'idCdiseno',
    fields: [
        {name: 'colordiseno', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'idCdiseno', type: 'string'},
        {name: 'idObra', type: 'int'}
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLObraPintura',
            read: 'obraPinturas',
            update: 'uuLObraPintura',
            destroy: 'ddLObraPintura'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            allowSingle: false,
            writeAllFields: true
        }
    }
});
