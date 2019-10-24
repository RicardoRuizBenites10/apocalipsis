Ext.define('GrupoBruce.view.plantilla.Plantilla', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.plantilla.PlantillaController',
        'GrupoBruce.view.plantilla.PlantillaModel',

        'GrupoBruce.view.plantilla.FormPlantilla'
    ],

    controller: 'Cplantilla',
    viewModel: {
        type: 'VMplantilla'
    },

    items: [{
            xtype: 'Wlistcarroceria',
            height: 550,
            dockedItems: [{
                    xtype: 'toolbar',
                    overflowHandler: 'menu',
                    items: [{
                            iconCls: 'x-fa fa-file-text-o',
                            text: 'Manejo de especificaciones',
                            disabled: true,
                            bind: {
                                disabled: '{!selectCarroceria}'
                            },
                            handler: 'editPlantilla'
                        }]
                }]
        }]
});
