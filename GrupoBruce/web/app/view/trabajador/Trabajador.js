Ext.define('GrupoBruce.view.trabajador.Trabajador', {
    extend: 'Ext.panel.Panel',
    xtype: 'trabajadors',

    requires: [
        'GrupoBruce.view.trabajador.TrabajadorController',
        'GrupoBruce.view.trabajador.TrabajadorModel'

                , 'GrupoBruce.view.trabajador.ListTrabajador'
                , 'GrupoBruce.view.trabajador.FormTrabajador'

                , 'GrupoBruce.view.contrato.ContratoTrabajador'
                , 'GrupoBruce.view.hijo.HijoTrabajador'
    ],

    controller: 'Ctrabajador',
    viewModel: {
        type: 'VMtrabajador'
    },

    items: [{
            xtype: 'WlistTrabajador',
            plugins: 'responsive',
            responsiveConfig: {
                small: {
                    height: 300
                },
                medium: {
                    height: 540
                },
                large: {
                    height: 830
                }
            }
        }]

});
