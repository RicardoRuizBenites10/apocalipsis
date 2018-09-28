Ext.define('GrupoBruce.model.ContratoTrabajador', {
    extend: 'Ext.data.Model',

    idProperty: 'idTrabajador',
    fields: [
        { name: 'idTrabajador', type: 'string' },
        { name: 'idContrato', type: 'int' },
        {name: 'fechaCese', type: 'date'},
        {name: 'fechaFin', type: 'date'},
        {name: 'fechaInicio', type: 'date'},
        {name: 'idTcontrato', type: 'string'},
        {name: 'idEcontrato', type: 'int'},
        {name: 'idTiempo', type: 'int'}
    ],

    proxy: {
        type: 'ajax',
        api: {
            read: 'contratoByTrabajador',
            create: 'insertContrato',
            update: 'updateContrato',
            delete: 'deleteContrato'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
