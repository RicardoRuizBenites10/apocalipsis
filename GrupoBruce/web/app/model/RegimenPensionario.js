Ext.define('GrupoBruce.model.RegimenPensionario', {
    extend: 'Ext.data.Model',
    alias: 'model.MregimenPensionario',

    idProperty: 'idRpensionario',
    fields: [
        {name: 'codigo', type: 'string'},
        {name: 'cuspp', type: 'boolean'},
        {name: 'descripcion', type: 'string'},
        {name: 'idRpensionario', type: 'string'},
        {name: 'situacion', type: 'boolean'}
    ],

    identifier: {
        type: 'sequential'
    },

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiRegimenPensionario',
            read: 'regimenPensionarioBySituacion',
            update: 'uuRegimenPensionario',
            destroy: 'ddRegimenPensionario'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
