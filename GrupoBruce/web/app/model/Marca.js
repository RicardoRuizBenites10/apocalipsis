Ext.define('GrupoBruce.model.Marca', {
    extend: 'Ext.data.Model',
    alias: 'model.Mmarca',

    idProperty: 'idMarca',
    fields: [
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'hmarca', type: 'date', dateFormat: 'h:i A'},
        {name: 'idAsistencia', type: 'string'},
        {name: 'idMarca', type: 'string'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'situacion', type: 'boolean'},
        {name: 'trabajador', type: 'string'},
        {name: 'fechaTemp', type: 'date', dateFormat: 'c'}
    ],

    identifier: 'sequential',

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMarca',
            read: 'marcas',
            update: 'uuMarca',
            destroy: 'ddMarca'
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
