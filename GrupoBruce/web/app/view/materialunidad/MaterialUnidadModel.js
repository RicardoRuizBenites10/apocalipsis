Ext.define('GrupoBruce.view.materialunidad.MaterialUnidadModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmaterialunidad',
    data: {
        recordMaterial: null
    },
    
    stores: {
        unidadsmedida: {
            type: 'Sunidadmedida',
            autoLoad: true
        },
        materialunidads: {
            type: 'Smaterialunidad',
            session: true,
            autoLoad: true,
            filters: [{
                    property: 'idMaterial',
                    operator: 'EQ',
                    value: '{recordMaterial.idMaterial}'
            }]
        }
    }
    
});
