Ext.define('GrupoBruce.view.equipo.FormEquipo', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformEquipo',
    reference: 'form_equipo',

    controller: 'Cequipo',
    viewModel: {
        type: 'VMequipo'
    },

    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,
    width: 400,
    
    title: 'Editar equipo informatico',
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
                            fieldLabel: 'Nombre',
                            name: 'denominacion',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Serie',
                            name: 'serie',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'tipoEquipo',
                            fieldLabel: 'Tipo equipo',
                            displayLabel: 'descripcion',
                            displayValue: 'tipoEquipo',
                            editable: false,
                            bind: {
                                store: '{tiposEquipo}'
                            },
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
                                click: 'onSaveEquipo'
                            }
                        }]
        }]
});
