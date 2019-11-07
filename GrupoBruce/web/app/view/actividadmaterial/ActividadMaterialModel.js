Ext.define('GrupoBruce.view.actividadmaterial.ActividadMaterialModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMactividadmaterial',

    data: {
        recordActividad: null,
        selectActividad: null,
        selectMaterial: null
    },

    stores: {
        actividadmaterials: {
            type: 'Sactividadmaterial',
            autoLoad: true,
//            autoSync: '{!newRegister}',
//            trackRemoved: '{!newRegister}',
            filters: [{
                    property: 'ID_ACTIVIDAD',
                    operator: 'eq',
                    value: '{recordActividad.idActividad}'
                }]
        },
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
        },
        materialunidads: {
            type: 'Smaterialunidad',
            autoLoad: true,
            filters: [{
                    property: 'ID_EMPRESA',
                    operator: 'eq',
                    value: '{selectMaterial.idEmpresa}'
                }, {
                    property: 'ID_SUCURSAL',
                    operator: 'eq',
                    value: '{selectMaterial.idSucursal}'
                }, {
                    property: 'ID_MATERIAL',
                    operator: 'eq',
                    value: '{selectMaterial.idMaterial}'
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
            var store = Ext.getCmp('id_wactividadmaterial').getStore();
            var nm = [];
            store.each(function (item) {
                nm.push(item.get('idMaterial'));
            });
            return store.getCount() > 0 ? nm.toString() : 0;
        }
    }

});
