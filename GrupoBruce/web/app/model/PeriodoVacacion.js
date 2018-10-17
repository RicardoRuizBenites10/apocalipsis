Ext.define('GrupoBruce.model.PeriodoVacacion', {
    extend: 'Ext.data.Model',
    alias: 'model.MPeriodoVacacion',
    
    idProperty: 'idPVacacion',
    fields: [
        {name: 'cerrado', type: 'boolean'},
        {name: 'idPVacacion', type: 'int'},
        {name: 'limFin', type: 'date', dateFormat: 'c'},
        {name: 'limInicio', type: 'date', dateFormat: 'c'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
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
