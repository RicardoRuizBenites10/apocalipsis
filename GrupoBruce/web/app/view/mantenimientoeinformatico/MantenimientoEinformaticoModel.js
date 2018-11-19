Ext.define('GrupoBruce.view.mantenimientoeinformatico.MantenimientoEinformaticoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmantenimientoeinformatico',
    data: {
        title: 'Lista de mantenimientos',
        recordAsignacion: null
    },
    
    stores: {
        mantenimientosEinformatico: {
            type: 'Smantenimiento',
            autoLoad: true
        }
    }

});
