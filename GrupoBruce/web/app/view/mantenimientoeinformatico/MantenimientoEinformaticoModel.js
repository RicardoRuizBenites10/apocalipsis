Ext.define('GrupoBruce.view.mantenimientoeinformatico.MantenimientoEinformaticoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmantenimientoeinformatico',
    data: {
        title: 'Lista de mantenimientos',
        recordAsignacion: null,
        selectMantenimientoEinformatico: null
    },
    
    stores: {
        tiposMantenimiento : {
            type: 'StipoMantenimiento',
            autoLoad: true
        },
        mantenimientosEinformatico: {
            type: 'Smantenimiento',
            autoLoad: true,
            filters: [{
                    property: 'ID_AEQUIPO',
                    value: '{recordAsignacion.idAequipo}'
            }]
        }
    }

});
