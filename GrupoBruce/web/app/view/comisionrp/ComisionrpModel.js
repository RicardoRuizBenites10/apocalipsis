Ext.define('GrupoBruce.view.comisionrp.ComisionrpModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcomisionrp',
    data: {
        title: 'Lista de comisiones',
        recordRegimenPensionario: null,
        selectComisionrp: null
    },

    stores: {
        comisionsrp: {
            type: 'Scomisionrp',
            autoLoad: true,
            filters: [{
                    property: 'idRpensionario',
                    value: '{recordRegimenPensionario.idRpensionario}'
                }]
        }
    }

});
