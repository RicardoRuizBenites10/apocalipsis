Ext.define('GrupoBruce.view.carroceriamodelo.FormCarroceriaModelo', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wcarroceriamodelo',
    reference: 'form_carroceriamodelo',

    controller: 'Ccarroceriamodelo',
    viewModel: 'VMcarroceriamodelo',

    modal: true,
    closable: false,
    resizable: false,
    title: 'Editar modelo carrocería',
    width: 400,

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
                            name: 'idCarmod',
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
                        click: 'onSaveCarroceriaModelo'
                    }
                }]
        }]
});