Ext.define('GrupoBruce.view.colordiseno.ColorDisenoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcolordiseno',
    data: {
        name: 'GrupoBruce',
        newRegister: null,
        selectColorDiseno: null
    },

    stores: {
        colordisenos: {
            type: 'Scolordiseno',
            autoLoad: true
        },
        lastColorDiseno: {
            type: 'Scolordiseno',
            loading: true,
            autoLoad: true,
            filters: [{
                    property: 'idCdiseno',
                    operator: 'eq',
                    value: '{idCdiseno}'
                }]
        }
    }

});
