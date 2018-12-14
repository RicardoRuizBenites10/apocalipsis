Ext.define('GrupoBruce.model.Acceso', {
    extend: 'Ext.data.Model',
    alias: 'model.Macceso',

    idProperty: 'idMenu',
    fields: [
        {name: 'checked', type: 'boolean'},
        {name: 'fechaUpdate', type: 'date'},
        {name: 'idMenu', type: 'string'},
        {name: 'idRol', type: 'string'},
        {name: 'text', type: 'string'},
        {name: 'idSupmenu', type: 'string'},
        {name: 'leaf', type: 'boolean'}
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiAcceso',
            read: 'accesos',
            update: 'uuAcceso',
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
