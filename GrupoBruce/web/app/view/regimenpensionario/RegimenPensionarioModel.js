Ext.define('GrupoBruce.view.regimenpensionario.RegimenPensionarioModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMregimenpensionario',
    data: {
        title: 'Lista de regimenes pensionarios',
        selectRegimenPensionario: null
    },

    stores: {
        regimensPensionario: {
            type: 'SregimenPensionario',
            autoLoad: true
        }
    }

});
