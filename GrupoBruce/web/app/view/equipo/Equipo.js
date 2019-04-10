Ext.define('GrupoBruce.view.equipo.Equipo', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.Wequipo',
    reference: 'equipo',

    requires: [
        'GrupoBruce.view.equipo.EquipoController',
        'GrupoBruce.view.equipo.EquipoModel',

        'GrupoBruce.view.equipo.ListEquipo',
        'GrupoBruce.view.equipo.FormEquipo'
    ],

    controller: 'Cequipo',
    viewModel: {
        type: 'VMequipo'
    },

    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistEquipo',
            id: 'id_wequipo',
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
