Ext.define('GrupoBruce.model.Vacacion', {
    extend: 'Ext.data.Model',
    alias: 'model.Mvacacion',

    idProperty: 'idVacacion',
    fields: [
        {name: 'diasTomados', type: 'int'},
        {name: 'fechaBase', type: 'date', dateFormat: 'c'},
        {name: 'fechaRetorno', type: 'date', dateFormat: 'c'},
        {name: 'fechaSalida', type: 'date', dateFormat: 'c'},
        {name: 'idPVacacion', type: 'int'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'idVacacion', type: 'string'},
        {name: 'idTVacacion', type: 'int'}
    ],

    proxy: {
        type: 'ajax',
        api: {
            create: 'insertVacacion',
            read: 'vacacions',
            update: 'updateVacacion',
            destroy: 'deleteVacacion'
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
