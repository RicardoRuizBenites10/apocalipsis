Ext.define('GrupoBruce.view.area.FormArea', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformArea',
    reference: 'form_area',
    
    controller: 'Carea',
    viewModel: {
        type: 'VMarea'
    },

    bind: {
        title: '{title}'
    },
    
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
                            name: 'nombre',
                            fieldLabel: 'Nombre de área funcional',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'textareafield',
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
                        click: 'onSaveArea'
                    }
                }]
        }]

});
