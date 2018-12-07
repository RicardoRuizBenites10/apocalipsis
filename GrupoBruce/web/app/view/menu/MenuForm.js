Ext.define('GrupoBruce.view.menu.FormMenu',{
    extend: 'Ext.window.Window',
    alias: 'widget.WformMenu',
    reference: 'form_menu',
    
        controller: 'Cmenu',
    viewModel: {
        type: 'VMmenu'
    },

    title: 'Editar opción de menú',
    
    width: 400,
    resizable: false,
    modal: true,
    closable: false,
    autoShow: true,

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
                            name: 'text',
                            fieldLabel: 'Descripción',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'textfield',
                            name: 'iconCls',
                            fieldLabel: 'Icono',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'textfield',
                            name: 'handler',
                            fieldLabel: 'Handler',
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
                        click: 'onSaveMenu'
                    }
                }]
        }]

});