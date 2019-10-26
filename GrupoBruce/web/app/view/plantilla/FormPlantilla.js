Ext.define('GrupoBruce.view.plantilla.FormPlantilla', {
    extend: 'Ext.window.Window',
    alis: 'widget.Wformplantilla',
    reference: 'form_plantilla',
    id: 'id_wformplantilla',

    controller: 'Cplantilla',
    viewModel: {
        type: 'VMplantilla'
    },

    modal: true,
    resizable: false,
    width: 600,
    autoShow: true,

    title: 'Manejo de especifiaciones',
    items: [{
            xtype: 'form',
            defaults: {
                defaults: {
                    padding: 5
                }
            },
            items: [{
                    items: [{
                            xtype: 'grid',
                            bind: {
                                store: '{plantillas}'
                            },
                            flex: 1,
                            height: 400,
                            columns: [{
                                    text: 'Categoría',
                                    dataIndex: 'categoria'
                                }, {
                                    text: 'Especificación',
                                    dataIndex: 'especificacion',
                                    width: 300
                                }, {
                                    text: 'Actualización',
                                    dataIndex: 'fechaUpdate',
                                    formatter: 'date("d/m/Y")'
                                }],
                            dockedItems: [{
                                    xtype: 'toolbar',
                                    overflowHandler: 'menu',
                                    items: [{
                                            xtype: 'textfield',
                                            fieldLabel: 'Modelo',
                                            labelWidth: 50,
                                            readOnly: true,
                                            bind: {
                                                value: '{recordCarroceria.idCarroceria}'
                                            }
                                        }, {
                                            text: 'Actualizar',
                                            iconCls: 'x-fa fa-edit',
                                            handler: 'onPlantillaChange'
                                        }]
                                }]
                        }]
                }]
        }]
});