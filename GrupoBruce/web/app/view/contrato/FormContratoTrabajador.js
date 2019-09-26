Ext.define('GrupoBruce.view.contrato.FormContratoTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformContratoTrabajador',
    reference: 'form_contratoTrabajador',

//    requires: [
//        'Ext.ux.TreePicker'
//    ],

    viewModel: {
        type: 'VMcontratoTrabajador'
    },
    controller: 'CcontratoTrabajador',

    width: 600,
    resizable: false,
    closable: false,
    modal: true,
    autoShow: true,
    title: 'Editar contrato',

    items: [
        {
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
                            name: 'idTcontrato',
                            fieldLabel: 'Tipo contrato:',
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idTcontrato',
                            editable: false,
                            forceSelection: true,
                            bind: {
                                store: '{tipoContratos}'
                            },
                            flex: 2
                        }, {
                            xtype: 'numberfield',
                            name: 'montoContrato',
                            fieldLabel: 'Remuneración',
                            allowDecimals: true,
                            hideTrigger: true,
                            minValue: 0,
                            flex: 1
                        }
                    ]
                }, {
                    items: [{
                            xtype: 'treepicker',
                            id: 'id_treeareatrabajo',
                            fieldLabel: 'Área de trabajo',
                            displayField: 'nombre',
                            valueField: 'idArea',
                            bind: {
                                store: '{areas}',
                                value: '{miCodex}'
                            },
                            emptyText: 'Seleccionar',
                            editable: false,
                            flex: 1,
                            listeners: {
                                select: function (picker, record) {
                                    picker.up('window').getViewModel().set('selectArea', record.get('idArea'));
                                }
                            }
                        }
                    ]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idCargo',
                            fieldLabel: 'Cargo a desempeñar',
                            editable: false,
                            emptyText: 'Seleccionar',
                            displayField: 'nombre',
                            valueField: 'idCargo',
                            forceSelection: true,
                            bind: {
                                store: '{cargos}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'fechaInicio',
                            fieldLabel: 'Inicio contrato:',
                            format: 'd/m/Y',
                            bind: '{currentDate}',
                            flex: 1
                        }, {
                            xtype: 'combo',
                            name: 'idTiempo',
                            fieldLabel: 'Tiempo',
                            editable: false,
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idTiempo',
                            bind: {
                                store: '{tiempoCotratos}',
                                selection: '{selectTiempo}'
                            },
                            flex: 1
                        }, {
                            xtype: 'datefield',
                            name: 'fechaFin',
                            allowBlank: true,
                            readOnly: true,
                            fieldLabel: 'Fin de contrato',
                            format: 'd/m/Y',
                            bind: '{fin}',
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
                        click: 'onSaveContrato'
                    }
                }]
        }
    ]
});
