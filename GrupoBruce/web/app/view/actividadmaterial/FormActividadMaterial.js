Ext.define('GrupoBruce.view.actividadmaterial.FormActividadMaterial', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformactividadmaterial',
    reference: 'form_actividadmaterial',
    id: 'id_wformactividadmaterial',

    controller: 'Cactividadmaterial',
    viewModel: {
        type: 'VMactividadmaterial'
    },

    modal: true,
    closable: false,
    width: 400,
    title: 'Editar material de actividad',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    padding: 10,
                    labelAlign: 'top'
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
                                selection : '{selectMaterial}'
                            },
                            emptyText: 'Seleccionar',
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
                },{
                    items: [{
                            xtype: 'numberfield',
                            fieldLabel: 'Cantidad',
                            name: 'cantidad',
                            hideTrigger: true,
                            allowDecimal: true,
                            decimalPrecision: 5,
                            minValue: 0,
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
                        click: 'onSaveActividadMaterial'
                    }
                }]
        }]
});