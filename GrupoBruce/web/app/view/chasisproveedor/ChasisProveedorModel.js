Ext.define('GrupoBruce.view.chasisproveedor.ChasisProveedorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMchasisproveedor',

    stores: {
        chasisproveedors: {
            type: 'Schasisproveedor',
            autoLoad: true
        }
    }

});
