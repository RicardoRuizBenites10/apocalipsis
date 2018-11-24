Ext.define('GrupoBruce.model.MantenimientoProceso', {
    extend: 'Ext.data.Model',
    alias: 'model.MmantenimientoProceso',

    idProperty: 'idMproceso',
    fields: [
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'idAequipo', type: 'string'},
        {name: 'idEmantenimiento', type: 'string'},
        {name: 'idGenerador', type: 'string'},
        {name: 'idMantenimiento', type: 'string'},
        {name: 'idMproceso', type: 'string'},
        {name: 'idSolucionador', type: 'string'},
        {name: 'observacion', type: 'string'}
    ],
    
    identifier: 'sequential',

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMantenimientoProceso',
            read: 'mantenimientosProceso',
            update: 'uuMantenimientoProceso',
            destroy: 'ddMantenimientoProceso'
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
