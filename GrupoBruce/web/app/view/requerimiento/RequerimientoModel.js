Ext.define('GrupoBruce.view.requerimiento.RequerimientoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMrequerimiento',
    data: {
        selectObra: null,
        recordObra: null,
        selectEtapaProceso: null,
        selectRequerimientoActividad: null
    },

    stores: {
        obras: {
            type: 'Sobra',
            autoLoad: true
        },
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
                }]
        },
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true
        }
    }
});
