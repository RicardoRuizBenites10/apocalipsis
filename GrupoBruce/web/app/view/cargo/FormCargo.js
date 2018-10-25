Ext.define('GrupoBruce.view.cargo.FormCargo', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformCargo',
    reference: 'form_Cargo',

    modal: true,
    closable: false,
    resizable: false,
    width: 400,
    
    bind: {
        title: '{title}'
    },

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
                            fieldLabel: 'Nombre de cargo',
                            name: 'nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textareafield',
                            fieldLabel: 'Descripcion',
                            name: 'descripcion',
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
                        click: 'onSaveCargo'
                    }
                }]
        }]

});


