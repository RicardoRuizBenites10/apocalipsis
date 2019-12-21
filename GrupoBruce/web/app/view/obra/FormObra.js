Ext.define('GrupoBruce.view.obra.FormObra', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformobra',
    reference: 'form_obra',
    id: 'id_wformobra',

    requires: [
        'GrupoBruce.view.obracontratista.ObraContratista'
    ],

    controller: 'Cobra',
    viewModel: {
        type: 'VMobra'
    },

    modal: true,
    autoShow: true,
    closable: false,
    resizable: false,
    scrollable: true,
    width: 400,
    maxHeight: Ext.getBody().getViewSize().height * 0.8,

    title: 'Editar orden de producción',
    items: [{
            xtype: 'form',
            items: [{
                    xtype: 'tabpanel',
                    items: [{
                            title: 'Datos generales',
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
                                            name: 'idObrtip',
                                            fieldLabel: 'Tipo OP',
                                            displayField: 'descripcion',
                                            valueField: 'idObrtip',
                                            bind: {
                                                store: '{obratipos}',
                                                selection: '{selectObraTipo}',
                                                disabled: '{!newRegister}'
                                            },
                                            emptyText: 'Seleccionar',
                                            editable: false,
                                            forceSelection: true,
                                            listeners: {
                                                change: 'onChangeTOP'
                                            }
                                        }, {
                                            xtype: 'textfield',
                                            name: 'nombre',
                                            fieldLabel: 'Denominación OP',
                                            bind: '{nombreOP}',
                                            readOnly: true
                                        }]
                                }, {
                                    items: [{
                                            layout: 'hbox',
                                            defaults: {
                                                allowBlank: false,
                                                labelAlign: 'top',
                                                hideTrigger: true
                                            },
                                            items: [{
                                                    xtype: 'numberfield',
                                                    fieldLabel: 'Tipo',
                                                    bind: {
                                                        value: '{selectObraTipo.idObrtip}'
                                                    },
                                                    editable: false,
                                                    maxLength: 2,
                                                    width: 45
                                                }, {
                                                    xtype: 'displayfield',
                                                    value: '-',
                                                    margin: '30 5 0 5'
                                                }, {
                                                    xtype: 'numberfield',
                                                    name: 'numero',
                                                    bind: {
                                                        value: '{numeroOP}',
                                                        readOnly: '{!newRegister}'
                                                    },
                                                    fieldLabel: 'Nro.',
                                                    maxLength: 3,
                                                    minValue: 1,
                                                    width: 50
                                                }, {
                                                    xtype: 'displayfield',
                                                    value: '-',
                                                    margin: '30 5 0 5'
                                                }, {
                                                    xtype: 'numberfield',
                                                    name: 'anio',
                                                    fieldLabel: 'Año',
                                                    bind: {
                                                        value: '{anioOP}'
                                                    },
                                                    editable: false,
                                                    maxLength: 2,
                                                    width: 45
                                                }],
                                        }, {
                                            xtype: 'numberfield',
                                            name: 'nroChasis',
                                            fieldLabel: 'Nro. Chasis',
                                            allowBlank: true,
                                            maxLength: 14,
                                            hideTrigger: true
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'combobox',
                                            name: 'idProforma',
                                            fieldLabel: 'Proforma',
                                            displayField: 'idProforma',
                                            valueField: 'idProforma',
                                            bind: {
                                                store: '{proformas}',
                                                selection: '{selectProforma}'
                                            },
                                            emptyText: 'Seleccionar',
                                            editable: false,
                                            forceSelection: true
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'textfield',
                                            fieldLabel: 'Cliente',
                                            bind: {
                                                value: '{selectProforma.cliente}'
                                            },
                                            width: 354
                                        }]
                                }, {
                                    flex: 3,
                                    items: [{
                                            xtype: 'datefield',
                                            name: 'fechaIngreso',
                                            fieldLabel: 'Inicio programado:',
                                            format: 'd/m/Y',
                                            bind: {
                                                value: '{ini_fecha}',
                                                maxValue: '{fin_fecha}'
                                            }
                                        }, {
                                            xtype: 'datefield',
                                            name: 'fechaSalida',
                                            fieldLabel: 'Fin programado:',
                                            format: 'd/m/Y',
                                            bind: {
                                                value: '{fin_fecha}',
                                                minValue: '{ini_fecha}'
                                            }
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'combo',
                                            name: 'idEobra',
                                            fieldLabel: 'Situación',
                                            valueField: 'idEobra',
                                            displayField: 'nombre',
                                            bind: {
                                                store: '{estadoobras}',
                                                selection: '{selectEstadoObra}'
                                            },
                                            emptyText: 'Seleccionar',
                                            editable: false,
                                            forceSelection: true
                                        }]
                                }]
                        }, {
                            title: 'Asignacion de contratistas',
                            items: [{
                                    xtype: 'Wobracontratista'
                                }]
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
                        click: 'onSaveObra'
                    }
                }]
        }]

});