Ext.define('GrupoBruce.view.estado.FormEstado', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformEstado',
    reference: 'form_estado',

    controller: 'Cestado',
    viewModel: {
        type: 'VMestado'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar proceso',
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
                            name: 'descripcion',
                            fieldLabel: 'Situación',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'accion',
                            fieldLabel: 'Acción',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            bind: {
                                store: '{estados}',
                                selection: '{selectPrecede}'
                            },

                            allowBlank: true,
                            fieldLabel: 'Estado que precede',
                            name: 'idPrecede',
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idEstado',
                            editable: false,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'solucionador',
                            fieldLabel: 'Solucionador',
                            boxLabel: 'Si',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            allowDecimals: false,
                            hideTrigger: true,
                            minValue: 1,
                            name: 'orden',
                            fieldLabel: 'Órden',
                            bind: {
                                value: '{numOrden}'
                            },
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
                        click: 'onSaveEstado'
                    }
                }]
        }]
});