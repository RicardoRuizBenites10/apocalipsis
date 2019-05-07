Ext.define('GrupoBruce.view.carroceriafalda.FormCarroceriaFalda', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformcarroceriafalda',
    reference: 'form_carroceriafalda',
    id: 'id_wformcarroceriafalda',

    controller: 'Ccarroceriafalda',
    viewModel: 'VMcarroceriafalda',

    width: 400,
    modal: true,
    autoShow: true,
    closable: true,
    resizable: true,

    title: 'Editar falda carrocería',
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
                            name: 'idCarfal',
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
                        click: 'onSaveCarroceriaFalda'
                    }
                }]
        }]
});