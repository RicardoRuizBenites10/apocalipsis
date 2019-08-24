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
            autoLoad: true,
            filters: [{
                    property: 'ID_EMPRESA',
                    operator: 'eq',
                    value: '{idEmpresa}'
                }, {
                    property: 'ID_SUCURSAL',
                    operator: 'eq',
                    value: '{idSucursal}'
                }]
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
    },

    formulas: {
        idEmpresa: function (get) {
            var modMain = Ext.getCmp('id_wmain').getViewModel();
            return modMain.get('selectEmpresa').get('idEmpresa');
        },

        idSucursal: function (get) {
            var modMain = Ext.getCmp('id_wmain').getViewModel();
            return modMain.get('selectSucursal').get('idSucursal');
        }
    }

});
