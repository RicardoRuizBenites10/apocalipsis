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
                            xtype: 'datefield',
                            name: 'fechaBase',
                            format: 'd/m/Y',
                            fieldLabel: 'Inicio de uso'
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idTequipo',
                            fieldLabel: 'Tipo equipo',
                            displayField: 'descripcion',
                            valueField: 'idTequipo',
                            editable: false,
                            bind: {
                                store: '{tiposEquipo}'
                            },
                            listeners: {
                                change: 'generateSerie'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'serie',
                            fieldLabel: 'Serie',
                            editable: false,
                            bind: '{serie}',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            fieldLabel: 'Descripción',
                            name: 'denominacion',
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
