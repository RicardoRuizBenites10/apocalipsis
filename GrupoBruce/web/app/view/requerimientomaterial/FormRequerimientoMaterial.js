Ext.define('GrupoBruce.view.requerimientomaterial.FormRequerimientoMaterial', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformrequerimientomaterial',
    reference: 'form_requerimientomaterial',
    id: 'id_wformrequerimientomaterial',

    controller: 'Crequerimientomaterial',
    viewModel: {
        type: 'VMrequerimientomaterial'
    },

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
                            name: 'idMaterial',
                            valueField: 'idMaterial',
                            displayField: 'nombre',
                            bind: {
                                store: '{materials}',
                                selection: '{selectMaterial}'
                            },
                            emptyText: 'Buscar..',
                            hideTrigger: true,
                            forceSelection: true,
                            minChars: 3,
                            pageSize: true,
                            triggerAction: 'query',
                            flex: 1

                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Unidad medida',
                            name: 'idUmedida',
                            valueField: 'idUmedida',
                            displayField: 'idUmedida',
                            bind: {
                                store: '{materialunidads}',
                                selection: '{selectMaterialUnidad}'
                            },
                            emptyText: 'Seleccionar',
                            forceSelection: true,
                            editable: false,
                            flex: 1
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
                        click: 'onSaveMaterial'
                    }
                }]
        }]
});