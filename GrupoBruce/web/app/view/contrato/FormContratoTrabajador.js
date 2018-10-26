Ext.define('GrupoBruce.view.contrato.FormContratoTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformContratoTrabajador',
    reference: 'form_contratoTrabajador',

    bind: {
        title: '{title}'
    },
    width: 550,
    resizable: false,
    closable: false,
    modal: true,

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
                            name: 'idTcontrato',
                            fieldLabel: 'Tipo contrato:',
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idTcontrato',
                            bind: {
                                store: '{tipoContratos}'
                            },
                            flex: 2
                        }
//                        , {
//                            xtype: 'combobox',
//                            name: 'idEcontrato',
//                            fieldLabel: 'Estado contrato:',
//                            editable: false,
//                            emptyText: 'Seleccionar',
//                            displayField: 'descripcion',
//                            valueField: 'idEcontrato',
//                            bind: {
//                                store: '{estadoContratos}'
//                            },
//                            flex: 1
//                        }
                    ]
                }, {
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Área de trabajo',
                            valueField: 'idArea',
                            displayField: 'nombre',
                            name: 'idArea',
                            editable: false,
                            forceSelection: true,
                            emptyText: 'Seleccionar',
                            bind: {
                                store: '{areas}',
                                selection: '{selectArea}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Cargo a desempeñar',
                            valueField: 'idCargo',
                            displayField: 'nombre',
                            name: 'idCargoa',
                            editable: false,
                            forceSelection: true,
                            emptyText: 'Seleccionar',
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
        }]


});
