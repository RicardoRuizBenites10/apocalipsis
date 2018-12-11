Ext.define('GrupoBruce.view.rol.FormRol', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformRol',
    reference: 'form_rol',
    
    controller: 'Crol',
    viewModel: {
        type: 'VMrol'
    },
    
    modal: true,
    closable: false,
    resizable: false,
    width: 400,
    autoShow: true,

    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    padding: 5,
                    allowBlank: false,
                    labelAlign: 'top'
                }
            },
            items: [{
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Denominación'
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