Ext.define('GrupoBruce.view.prestamopago.PrestamoPago',{
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.prestamopago.PrestamoPagoController',
        'GrupoBruce.view.prestamopago.PrestamoPagoModel',
        
        'GrupoBruce.view.prestamopago.ListPrestamoPago'
    ],

    controller: 'Cprestamopago',
    viewModel: {
        type: 'VMprestamopago'
    },
    
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,
    
    title: 'Pagos de prestamo',
    items: [{
            xtype: 'WlistPrestamoPago',
            width: 600,
            height: 400
    }]
});
