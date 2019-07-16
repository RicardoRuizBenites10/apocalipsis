Ext.define('GrupoBruce.view.materialsubfamilia.MaterialSubfamiliaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmaterialsubfamilia',
    data: {
        name: 'GrupoBruce',
        recordMaterialFamilia: null
    },

    stores: {
        materialsfamilia: {
            type: 'Smaterialfamilia',
            autoLoad: true,
            filters: [{
                    property: 'idFamilia',
                    value: '{recordMaterialFamilia.idFamilia}',
                    operator: 'EQ'
                }]
        },
        materialssubfamilia: {
            type: 'Smaterialsubfamilia',
            autoLoad: true,
            filters: [{
                    property: 'idFamilia',
                    value: '{recordMaterialFamilia.idFamilia}',
                    operator: 'EQ'
                }]
        }
    }

});
