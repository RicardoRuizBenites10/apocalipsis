Ext.define('GrupoBruce.view.actividad.ActividadModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMactividad',
    data: {
        selectActividad: null
    },

    stores: {
        actividads: {
            type: 'Sactividad',
            autoLoad: true
        },
        eprocesos: {
            type: 'Setapaproceso',
            autoLoad: true
        },
        monedas: {
            type: 'Smoneda',
            autoLoad: true
        }
    }

});
