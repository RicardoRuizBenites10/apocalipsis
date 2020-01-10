Ext.define('GrupoBruce.view.obrapintura.ObraPinturaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobrapintura',
    data: {
        name: 'GrupoBruce'
    },

    stores: {
        obrapinturas: {
            type: 'Sobrapintura',
            autoLoad: true,
            filters: [{
                    property: 'ID_OBRA',
                    operator: 'eq',
                    value: '{recordObra.idObra}'
                }]
        },
        colordisenos: {
            type: 'Scolordiseno',
            autoLoad: true
        }
    }

});
