Ext.define('GrupoBruce.view.estado.FormEstado',{
    extend: 'Ext.window.Window',
    alias: 'widget.WformEstado',
    reference: 'form_estado',
    
    controller: 'Cestado',
    viewModel: {
        type: 'VMestado'
    },
    
        modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar proceso',
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
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'entidad',
                            fieldLabel: 'Entidad a manejar',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'descripcion',
                            fieldLabel: 'Descripción',
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
                        click: 'onSaveEstado'
                    }
                }]
        }]
});