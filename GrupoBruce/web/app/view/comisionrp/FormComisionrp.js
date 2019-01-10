Ext.define('GrupoBruce.view.comisionrp.FormComisionrp', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformComisionrp',
    reference: 'form_comisionrp',

    controller: 'Ccomisionrp',
    viewModel: {
        type: 'VMcomisionrp'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    items: [{
            xtype: 'form',
            defaults: {
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
                            name: 'descripcion',
                            fieldLabel: 'Descripción',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            hideTrigger: true,
                            minValue: 0,
                            name: 'fondo',
                            fieldLabel: 'Fondo',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            hideTrigger: true,
                            minValue: 0,
                            name: 'seguro',
                            fieldLabel: 'Seguro',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            hideTrigger: true,
                            minValue: 0,
                            name: 'comision',
                            fieldLabel: 'Comisión',
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
                        click: 'onSaveComisionrp'
                    }
                }]
        }]
});