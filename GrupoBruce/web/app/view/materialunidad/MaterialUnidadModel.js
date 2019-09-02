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
            trackRemoved : '{!newRegister}',
            filters: [{
                    property: 'ID_EMPRESA',
                    operator: 'EQ',
                    value: '{recordMaterial.idEmpresa}'
            },{
                    property: 'ID_SUCURSAL',
                    operator: 'EQ',
                    value: '{recordMaterial.idSucursal}'
            },{
                    property: 'ID_MATERIAL',
                    operator: 'EQ',
                    value: '{recordMaterial.idMaterial}'
            }]
        }
    }
    
});
