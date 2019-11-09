Ext.define('GrupoBruce.view.obra.ObraModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobra',
    data: {
        selectObra: null
    },

    stores: {
        obratipos: {
            type: 'Sobratipo',
            autoLoad: true
        },
        proformas: {
            type: 'Sproforma',
            autoLoad: true
        }
    }

});
