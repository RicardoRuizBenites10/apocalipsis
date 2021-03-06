Ext.define('GrupoBruce.view.contrato.ContratoTrabajador', {
    extend: 'Ext.window.Window',
    reference: 'panel_contrato',

    requires: [
        'GrupoBruce.view.contrato.ContratoTrabajadorController',
        'GrupoBruce.view.contrato.ContratoTrabajadorModel',
        
        'GrupoBruce.view.contrato.ListContratoTrabajador',
        'GrupoBruce.view.contrato.FormContratoTrabajador',
        'GrupoBruce.view.contrato.FormContratoFinalizar'
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
    bind: {
        title: '{title}'
    },

    items: [{
            xtype: 'WcontratoTrabajador',
            id: 'id_wcontratotrabajador',
            height: 355
        }]
});
