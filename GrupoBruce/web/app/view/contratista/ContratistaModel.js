Ext.define('GrupoBruce.view.contratista.ContratistaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcontratista',
    data: {
        titulo: 'Lista de contratistas'
    },
    
    stores: {
        contratistas: {
            type: 'Scontratista',
            autoLoad: true
        },
        etapasproceso: {
            type: 'Setapaproceso',
            autoLoad: true
        }
    }

});
