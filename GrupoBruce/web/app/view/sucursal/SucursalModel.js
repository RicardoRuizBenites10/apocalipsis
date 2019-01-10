Ext.define('GrupoBruce.view.sucursal.SucursalModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMsucursal',
    data: {
        title: 'Lista de sucursales',
        recordEmpresa: null,
        selectSucursal: null
    },

    stores: {
        sucursals: {
            type: 'Ssucursal',
            filters: [{
                    property: 'idEmpresa',
                    operator: 'eq',
                    value: '{recordEmpresa.idEmpresa}'
                }],
            autoLoad: true
        }
    }

});
