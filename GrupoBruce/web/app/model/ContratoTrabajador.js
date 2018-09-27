Ext.define('GrupoBruce.model.ContratoTrabajador', {
    extend: 'Ext.data.Model',

    idProperty: 'contratoTrabajadorIdId',
    fields: [
        {name: 'fechaCese', type: 'date'},
        {name: 'fechaFin', type: 'date'},
        {name: 'fechaInicio', type: 'date'},
        {name: 'idTcontrato', type: 'string'},
        {name: 'idEcontrato', type: 'int'},
        {name: 'idTiempo', type: 'int'},
        
        {name: 'contratoTrabajadorIdId', reference: 'GrupoBruce.model.ContratoTrabajadorId', unique: true}
    ],

    proxy: {
        type: 'ajax',
        api: {
            read: 'contratos',
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
