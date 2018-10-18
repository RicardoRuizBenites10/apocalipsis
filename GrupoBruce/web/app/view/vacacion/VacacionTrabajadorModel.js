Ext.define('GrupoBruce.view.vacacion.VacacionTrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMvacacionTrabajador',
    data: {
        title: 'Lista de vacaciones',
        recordTrabajador: null,
        diasVacacion: 30
    },

    stores: {
        vacacions: {
            type: 'Svacacion',
            autoLoad: true,
            filters: [{
                    property: 'idTrabajador',
                    value: '{recordTrabajador.idTrabajador}'
                }]
        },
        periodos: {
            type: 'SperiodoVacacion',
            autoLoad: true
        }
    },
    
    formulas: {
        fechaRetorno: function(get){
            
        }
    }

});
