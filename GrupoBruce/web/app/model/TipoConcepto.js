Ext.define('GrupoBruce.model.TipoConcepto', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoConcepto',

    idProperty: 'idTconcepto',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idTconcepto', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTipoConcepto',
            read: 'tiposConcepto',
            update: 'uuTipoConcepto',
            destroy: 'ddTipoConcepto'
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
