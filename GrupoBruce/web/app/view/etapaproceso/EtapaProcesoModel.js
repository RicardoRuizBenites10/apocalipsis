Ext.define('GrupoBruce.view.etapaproceso.EtapaProcesoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMetapaproceso',
    data: {
        titulo: 'Lista de áreas de producción'
    },

    stores: {
        etapasproceso: {
            type: 'Setapaproceso',
            autoLoad: true
        }
    }

});
