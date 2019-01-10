Ext.define('GrupoBruce.view.empresa.FormEmpresa', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformEmpresa',
    reference: 'form_empresa',

    controller: 'Cempresa',
    viewModel: {
        type: 'VMempresa'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar empresa',
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
                            name: 'ruc',
                            fieldLabel: 'Nro RUC',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'descripcion',
                            fieldLabel: 'Nombre',
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
                        click: 'onSaveEmpresa'
                    }
                }]
        }]
});