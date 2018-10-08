Ext.define('GrupoBruce.view.contrato.FormContratoTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformContratoTrabajador',
    reference: 'form_contratoTrabajador',

//    viewModel: {
//        type: 'VMcontratoTrabajador'
//    },
//    controller: 'CcontratoTrabajador',

    bind:{
        title: '{title}'
    },
    width: 550,
    resizable: false,
    closable: true,
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
                            xtype: 'textfield',
                            name: 'idTrabajador',
                            bind: {
                                value: '{recordTrabajador.idTrabajador}'
                            },
                            fieldLabel: 'Documento'
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idTcontrato',
                            fieldLabel: 'Tipo contrato:',
                            editable: false,
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idTcontrato',
                            bind: {
                                store: '{tipoContratos}'
                            },
                            flex: 2
                        }, {
                            xtype: 'combobox',
                            name: 'idEcontrato',
                            fieldLabel: 'Estado contrato:',
                            editable: false,
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idEcontrato',
                            bind: {
                                store: '{estadoContratos}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'fechaInicio',
                            fieldLabel: 'Inicio contrato:',
                            format: 'd/m/Y',
                            bind: '{inicio}'
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
                            }
                        }, {
                            xtype: 'textfield',
                            allowBlank: true,
                            editable: false,
                            name: 'fechaFin',
                            fieldLabel: 'Fin de contrato',
                            format: 'd/m/Y',
                            bind: '{fin}'
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
