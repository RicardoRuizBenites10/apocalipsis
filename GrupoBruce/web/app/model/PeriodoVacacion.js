Ext.define('GrupoBruce.model.PeriodoVacacion', {
    extend: 'Ext.data.Model',
    alias: 'model.MPeriodoVacacion',
    
    idProperty: 'idPVacacion',
    fields: [
        {name: 'cerrado', type: 'boolean'},
        {name: 'idPVacacion', type: 'int'},
        {name: 'limFin', type: 'date'},
        {name: 'limInicio', type: 'date'},
        {name: 'situacion', type: 'boolean'}
    ],
    
    proxy: {
        type: 'ajax',
        api:{
            create: 'insertPeriodoVacacion',
            read: 'periodosVacacion',
            update: 'updatePeriodoVacacion',
            destroy: 'deletePeriodoVacacion'
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
