Ext.define('GrupoBruce.view.colorformula.ColorFormulaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcolorformula',

    data: {
        recordColorDiseno: null
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
                }, {
                    property: 'ID_MATERIAL',
                    operator: 'nin',
                    value: '{nomaterial}'
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
        },
        
        nomaterial: function (get) {
            var store = Ext.getCmp('id_wcolorformula').getStore();
            var nm = [];
            store.each(function (item) {
                nm.push(item.get('idMaterial'));
            });
            return store.getCount() > 0 ? nm.toString() : 0;
        }
    }

});
