Ext.define('GrupoBruce.view.materialunidad.MaterialUnidadModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmaterialunidad',
    data: {
        recordMaterial: null,
        selectMaterialUnidad: null,
        hasBase: false
    },
    
    stores: {
        unidadsmedida: {
            type: 'Sunidadmedida',
            autoLoad: true
        },
        materialunidads: {
            type: 'Smaterialunidad',
            autoLoad: true,
            filters: [{
                    property: 'ID_MATERIAL',
                    operator: 'EQ',
                    value: '{recordMaterial.idMaterial}'
            }]
        }
    }
    
});
