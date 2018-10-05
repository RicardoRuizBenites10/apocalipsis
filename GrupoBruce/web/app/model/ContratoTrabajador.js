Ext.define('GrupoBruce.model.ContratoTrabajador', {
    extend: 'Ext.data.Model',

    idProperty: 'idContrato',
    fields: [
        {name: 'idTrabajador', type: 'string'},
        {name: 'idContrato', type: 'int'},
        {name: 'fechaCese', type: 'date', dateFormat:'c'},
        {name: 'fechaFin', type: 'date', dateFormat:'c'},
        {name: 'fechaInicio', type: 'date', dateFormat:'c'},
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
