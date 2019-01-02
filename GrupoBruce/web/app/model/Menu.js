Ext.define('GrupoBruce.model.Menu', {
    extend: 'Ext.data.Model',
    alias: 'model.Mmenu',

    idProperty: 'idMenu',
    fields: [
        {name: 'idMenu', type: 'string'},
        {name: 'idSupmenu', type: 'string'},
        {name: 'text', type: 'string'},
        {name: 'handler', type: 'string'},
        {name: 'iconCls', type: 'string'},
        {name: 'leaf', type: 'boolean'},
        {name: 'codProceso', type: 'string'},
        {name: 'proceso', type: 'boolean'}
    ],

    identifier: {
        type: 'sequential',
        prefix: '00'
    },

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMenu',
            read: 'maccesos',
            update: 'uuMenu',
            destroy: 'ddMenu'
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
