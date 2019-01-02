Ext.define('GrupoBruce.model.Acceso', {
    extend: 'Ext.data.Model',
    alias: 'model.Macceso',

    idProperty: 'idMenu',
    fields: [
        {name: 'idMenu', type: 'string'},
        {name: 'idSupmenu', type: 'string'},
        {name: 'text', type: 'string'},
        {name: 'leaf', type: 'boolean'},
        {name: 'checked', type: 'boolean'},
        {name: 'fechaUpdate', type: 'date', dateFormat: 'c'},
        {name: 'codProceso', type: 'string'},
        {name: 'proceso', type: 'boolean'},
        {name: 'idRol', type: 'string'}
    ],

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiAcceso',
            read: 'accesosRol',
            update: 'uuLAcceso',
            destroy: 'ddAcceso'
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
