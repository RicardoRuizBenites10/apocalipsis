Ext.define('GrupoBruce.view.requerimientomaterial.ForRequerimientoMaterial', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformrequerimientomaterial',
    reference: 'form_requerimientomaterial',
    id: 'id_wformrequerimientomaterial',

    modal: true,
    autoShow: true,
    closable: false,
    resizable: false,

    width: 500,
    title: 'Agregar material',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 7
                }
            },
            items: [{
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Material',
                            bind: {
                                store: '{materials}',
                                selection: '{selectMaterial}'
                            },
                            emptyText: 'Buscar..'
                        }]
                },{
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Unidad',
                            bind: {
                                store: '{materialunidads}',
                                selection: '{selectMaterialUnidad}'
                            },
                            emptyText: 'Seleccionar',
                            editable: false
                    }]
                }],
            buttons: [{
                    text: 'Cancelar',
                    listeners: {
                        click: function () {
                            this.up('form').reset();
                            this.up('window').close();
                        }
                    }
                }, {
                    text: 'Restablecer',
                    listeners: {
                        click: function () {
                            this.up('form').reset();
                        }
                    }
                }, {
                    text: 'Grabar',
                    iconCls: 'fa fa-save',
                    formBind: true,
                    listeners: {
                        click: 'onSaveRequerimientoMaterial'
                    }
                }]
        }]
});