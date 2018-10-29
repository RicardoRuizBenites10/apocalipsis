Ext.define('GrupoBruce.model.ContratoTrabajador', {
    extend: 'Ext.data.Model',
    alias: 'model.McontratoTrabajador',

    idProperty: 'idContrato',
    fields: [
        {name: 'idTrabajador', type: 'string'},
        {name: 'idContrato', type: 'int'},
        {name: 'fechaCese', type: 'date', dateFormat: 'c'},
        {name: 'fechaFin', type: 'date', dateFormat: 'c'},
        {name: 'fechaInicio', type: 'date', dateFormat: 'c'},
        {name: 'idTcontrato', type: 'string'},
        {name: 'idEcontrato', type: 'int'},
        {name: 'idTiempo', type: 'int'},
        {name: 'idArea', type: 'string'},
        {name: 'idCargo', type: 'string'},
        {name: 'montoContrato', type: 'float'}
    ],

    identifier: {
        type: 'sequential'
    },

    proxy: {
        type: 'ajax',
        api: {
            read: 'contratos',
            create: 'iiContrato',
            update: 'uuContrato',
            destroy: 'ddContrato'
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
