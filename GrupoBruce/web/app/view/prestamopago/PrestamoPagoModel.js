Ext.define('GrupoBruce.view.prestamopago.PrestamoPagoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMprestamopago',
    data: {
        recordPrestamo: null,
        selectPrestamoPago: null
    },

    stores: {
        prestamosPago: {
            type: 'SprestamoPago',
            autoLoad: true,
            filters: [{
                    property: 'idPrestamo',
                    operator: 'eq',
                    value: '{recordPrestamo.idPrestamo}'
                }]
        }
    }

});
