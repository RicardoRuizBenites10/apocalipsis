Ext.define('GrupoBruce.view.chasis.FormChasis', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformchasis',
    reference: 'form_chasis',

    controller: 'Cchasis',
    viewModel: 'VMchasis',

    width: 400,
    modal: true,
    closable: false,
    resizable: false,

    title: 'Editar chasis',
    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    allowBlank: 'false',
                    padding: 5
                }
            },
            items: [{
                    items: [{
                            xtype: 'combo',
                            name: 'idCarmod',
                            fieldLabel: 'Tipo carrocería',
                            displayField: 'nombre',
                            valueField: 'idCarmod',
                            bind: {
                                store: '{carroceriamodelos}',
                                selection: '{selectCarroceriaModelo}'
                            },
                            editable: false,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'modelo',
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            name: 'ddee',
                            fieldLabel: 'DDEE',
                            allowBlank: true,
                            allowDecimals: false,
                            hideTrigger: true,
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
                        click: 'onSaveChasis'
                    }
                }]
        }]
});