Ext.define('GrupoBruce.view.material.FormMaterial', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformmaterial',
    reference: 'form_material',
    id: 'id_wformmaterial',

    controller: 'Cmaterial',
    viewModel: {
        type: 'VMmaterial'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 500,
    title: 'Editar material',

    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 5
                }
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
                },{
                    items: [{
                            xtype: 'tagfield',
                            fieldLabel: 'Unidad de medida',
                            displayField: 'denominacion',
                            valueField: 'idUmedida',
                            forceSelection: true,
                            bind: {
                                store: '{unidadsmedida}'
                            },
                            flex: 1
                    }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            fieldLabel: 'Stock mínimo',
                            name: 'stockMinimo',
                            hideTrigger: true,
                            minValue: '0',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            fieldLabel: 'Stock máximo',
                            name: 'stockMaximo',
                            hideTrigger: true,
                            minValue: '0',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            boxLabel: 'Seguimiento de calidad',
                            name: 'segCalidad',
                            reference: 'chk_materialseguimientocalidad',
                            flex: 1
                        }, {
                            xtype: 'checkbox',
                            boxLabel: 'Fabricación interna',
                            name: 'autoparte',
                            reference: 'chk_materialautoparte',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'checkbox',
                            fieldLabel: 'Situación',
                            name: 'situacion',
                            reference: 'chk_situacionmaterial',
                            boxLabel: 'Activo',
                            width: '48%'
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