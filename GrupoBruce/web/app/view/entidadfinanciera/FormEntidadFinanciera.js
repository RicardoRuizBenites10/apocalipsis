Ext.define('GrupoBruce.view.entidadfinanciera.FormEntidadFinanciera',{
    extend: 'Ext.window.Window',
    alias: 'widget.WformEntidadFinanciera',
    reference: 'form_entidadFinanciera',

    controller: 'Centidadfinanciera',
    ViewModel: {
        type: 'VMentidadfinanciera'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar entidad financiera',
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
                            name: 'idEfinanciera',
                            fieldLabel: 'Código',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'textfield',
                            name: 'nombre',
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
                        click: 'onSaveEntidadFinanciera'
                    }
                }]
        }]
    
});