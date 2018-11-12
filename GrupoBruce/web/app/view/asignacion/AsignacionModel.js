Ext.define('GrupoBruce.view.asignacion.AsignacionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasignacion',
    
    data: {
        title: 'Lista de asignación de equipos'
    },
    
    stores: {
        asignacions: {
            type: 'SasignacionEquipo',
            autoLoad: true
        }
    }

});
