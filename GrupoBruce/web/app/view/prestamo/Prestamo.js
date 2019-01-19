Ext.define('GrupoBruce.view.prestamo.Prestamo', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.prestamo.PrestamoController',
        'GrupoBruce.view.prestamo.PrestamoModel',
        
        'GrupoBruce.view.prestamo.ListPrestamo',
        'GrupoBruce.view.prestamo.FormPrestamo'
    ],

    controller: 'Cprestamo',
    viewModel: {
        type: 'VMprestamo'
    },
    
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,
    
    title: 'Lista de prestamos',
    items: [{
            xtype: 'WlistPrestamo',
            width: 600,
            height: 400
        }]
});
