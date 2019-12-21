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
        colorformulas: {
            type: 'Scolorformula',
            autoLoad: true,
            filters: [{
                    property: 'M.ID_EMPRESA',
                    operator: 'eq',
                    inWhere: false,
                    value: '{idEmpresa}'
                }, {
                    property: 'M.ID_SUCURSAL',
                    operator: 'eq',
                    inWhere: false,
                    value: '{idSucursal}'
                }]
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
