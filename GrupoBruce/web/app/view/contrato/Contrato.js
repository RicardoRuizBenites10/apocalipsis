Ext.define('GrupoBruce.view.contrato.Contrato', {
    extend: 'Ext.window.Window',
    reference: 'panel_contrato',

    requires: [
        'GrupoBruce.view.contrato.ContratoTrabajadorController',
        'GrupoBruce.view.contrato.ContratoTrabajadorModel',
        
        'GrupoBruce.view.contrato.ListContratoTrabajador',
        'GrupoBruce.view.contrato.FormContratoTrabajador'
    ],

    viewModel: {
        type: 'VMcontratoTrabajador'
    },
    controller: 'CcontratoTrabajador',

    height: 400,
    width: 600,
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,

    items: [{
            xtype: 'WcontratoTrabajador',
            height: 355
        }]
});
