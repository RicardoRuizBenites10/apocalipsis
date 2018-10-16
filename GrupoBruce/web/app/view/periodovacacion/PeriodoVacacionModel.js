Ext.define('GrupoBruce.view.periodovacacion.PeriodoVacacionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMperiodoVacacion',
    
    data: {
        titulo: 'Lista de periodos vacación'
    },
    
    stores: {
        periodosVacacion: {
            type: 'SperiodoVacacion',
            autoLoad: true
        }
    }

});
