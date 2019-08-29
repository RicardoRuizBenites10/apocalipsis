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
            autoSync: '{!newRegister}',
            trackRemoved : '{newRegister}',
            filters: [{
                    property: 'ID_MATERIAL',
                    operator: 'EQ',
                    value: '{recordMaterial.idMaterial}'
            }]
        }
    }
    
});
