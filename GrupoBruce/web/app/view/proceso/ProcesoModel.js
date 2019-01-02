Ext.define('GrupoBruce.view.proceso.ProcesoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMproceso',
    data: {
        title: 'Lista de procesos'
    },
    
    stores: {
        procesos: {
            type: 'Sproceso',
            autoLoad: true
        }
    }

});
