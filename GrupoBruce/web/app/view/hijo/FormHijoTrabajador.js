Ext.define('GrupoBruce.view.hijo.FormHijoTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformHijoTrabajador',
    reference: 'form_hijoTrabajador',

    bind: {
        title: '{title}'
    },
    width: 410,
    resizable: false,
    closable: false,
    modal: true,

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
                            name: 'dni',
                            fieldLabel: 'DNI',
                            allowBlank: true,
                            flex: 1
                        }, {
                            xtype: 'datefield',
                            name: 'nacimiento',
                            fieldLabel: 'Nacimiento',
                            format: 'd/m/Y',
                            flex: 1
                        },{
                            xtype: 'combo',
                            name: 'idGenero',
                            fieldLabel: 'Genero',
                            editable: false,
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idGenero',
                            bind: {
                                store: '{generos}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nombres',
                            fieldLabel: 'Apellidos y nombres',
                            flex: 3
                        }]
                }
            ],

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
                        click: 'onSaveHijo'
                    }
                }]
        }]
});