Ext.define('GrupoBruce.view.material.FormMaterial', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformmaterial',
    reference: 'form_material',
    id: 'id_wformmaterial',

    requires: [
        'GrupoBruce.view.materialunidad.MaterialUnidad'
    ],

    controller: 'Cmaterial',
    viewModel: {
        type: 'VMmaterial'
    },

    modal: true,
    closable: false,
    resizable: false,
    scrollable: true,
    width: 400,
    maxHeight: Ext.getBody().getViewSize().height * 0.8,

    title: 'Editar material',
    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 7
                }
            },
            fieldDefaults: {
                labelAlign: 'right',
                labelWidth: 115,
                msgTarget: 'side'
            },

            items: [{
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Familia',
                            name: 'idFamilia',
                            displayField: 'descripcion',
                            valueField: 'idFamilia',
                            bind: {
                                store: '{materialsfamilia}',
                                selection: '{selectMaterialFamilia}'
                            },
                            emptyText: 'Selecionar',
                            editable: false,
                            forceSelection: true,
                            flex: 1
                        }, {
                            xtype: 'combobox',
                            fieldLabel: 'Subfamilia',
                            name: 'idSubfamilia',
                            displayField: 'descripcion',
                            valueField: 'idSubfamilia',
                            bind: {
                                store: '{materialssubfamilia}',
                                selection: '{selectMaterialSubfamilia}'
                            },
                            emptyText: 'Selecionar',
                            editable: false,
                            forceSelection: true,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Nombre',
                            name: 'nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            fieldLabel: 'Stock mínimo',
                            name: 'stockMinimo',
                            hideTrigger: true,
                            minValue: '0',
                            width: '32%'
                        }, {
                            xtype: 'numberfield',
                            fieldLabel: 'Stock máximo',
                            name: 'stockMaximo',
                            hideTrigger: true,
                            minValue: '0',
                            width: '32%'
                        }]
                }
                , {
                    layout: 'fit',
                    padding: '0 10 0 10',
                    allowBlank: true,
                    items: [{
                            xtype: 'fieldset',
                            title: 'Unidad de medida',
                            items: [{
                                    xtype: 'Wmaterialunidad'
                                }]
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'situacion',
                            reference: 'chk_situacionmaterial',
                            boxLabel: 'Está activo',
                            flex: 1
                        }, {
                            xtype: 'checkbox',
                            boxLabel: 'Es autoparte',
                            name: 'autoparte',
                            reference: 'chk_materialautoparte',
                            flex: 1
                        }, {
                            xtype: 'checkbox',
                            boxLabel: 'Revisa calidad',
                            name: 'segCalidad',
                            reference: 'chk_materialseguimientocalidad',
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