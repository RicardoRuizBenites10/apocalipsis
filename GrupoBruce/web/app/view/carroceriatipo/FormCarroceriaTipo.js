Ext.define('GrupoBruce.view.carroceriatipo.FormCarroceriaTipo', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformcarroceriatipo',
    reference: 'form_carroceriatipo',

    controller: 'Ccarroceriatipo',
    viewModel: 'VMcarroceriatipo',

    width: 400,
    modal: true,
    closable: false,
    resizable: false,

    title: 'Editar carrocería',
    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    allowBlank: 'false',
                    padding: 5
                }
            },
            items: [{
                    items: [{
                            xtype: 'textfield',
                            name: 'idCartip',
                            fieldLabel: 'Código',
                            bind: {
                                editable: '{newRegister}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nombre',
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'descripcion',
                            fieldLabel: 'Descripción',
                            allowBlank: true,
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
                        click: 'onSaveCarroceriaTipo'
                    }
                }]
        }]
});