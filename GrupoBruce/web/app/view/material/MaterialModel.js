Ext.define('GrupoBruce.view.material.MaterialModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmaterial',

    data: {
        titulo: 'Lista de materiales',
        selectMaterialFamilia: null
    },

    stores: {
        materials: {
            type: 'Smaterial',
            autoLoad: true
        },
        materialsfamilia: {
            type: 'Smaterialfamilia',
            autoLoad: true
        },
        materialssubfamilia: {
            type: 'Smaterialsubfamilia',
            autoLoad: true,
            filters: [{
                    property: 'idFamilia',
                    value: '{selectMaterialFamilia.idFamilia}',
                    operator: 'EQ'
                }]
        }
    }

});
