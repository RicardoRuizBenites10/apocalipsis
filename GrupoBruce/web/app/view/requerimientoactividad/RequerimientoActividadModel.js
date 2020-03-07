Ext.define('GrupoBruce.view.requerimientoactividad.RequerimientoActividadModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMrequerimientoactividad',
    data: {
        recordObra: null,
        fechaProgramado: new Date(),
        selectEtapaProceso_id: null,
        selectRequerimientoActividad: null
    },
    
    stores: {
        eprocesos: {
            type: 'Setapaproceso',
            autoLoad: true
        },
        requerimientoactividads: {
            type: 'Srequerimientoactividad',
            autoLoad: true,
            filters: [{
                    property: 'ID_OBRA',
                    operator: 'eq',
                    value: '{recordObra.idObra}'
                },{
                    property: 'AC.ID_EPROCESO',
                    operator: 'eq',
                    value: '{selectEtapaProceso_id}'
                }]
        },
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true
        }
    }

});
