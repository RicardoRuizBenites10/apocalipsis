Ext.define('GrupoBruce.view.requerimiento.Requerimiento', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.requerimiento.RequerimientoController',
        'GrupoBruce.view.requerimiento.RequerimientoModel',

        'GrupoBruce.view.requerimiento.ListObraRequerimiento'
    ],

    controller: 'Crequerimiento',
    viewModel: {
        type: 'VMrequerimiento'
    },

    title: 'Manejo de actividades de ordenes de producción',
    items: [{
            xtype: 'tabpanel',
            items: [{
                    title: 'Ejecución de actividades',
                    items: [{
                            xtype: 'Wlistobrarequerimiento',
                            height: 500
                        }]
                }, {
                    title: 'Programación'
                }]
        }]
});
