Ext.define('GrupoBruce.view.formacion.FormFormacion', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformFormacion',
    reference: 'form_formacion',

    controller: 'Cformacion',
    viewModel: {
        type: 'VMformacion'
    },

    width: 370,
    resizable: false,
    closable: false,
    modal: true,
    autoShow: true,
    title: 'Editar estudio',

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
                            xtype: 'combo',
                            name: 'idTformacion',
                            fieldLabel: 'Tipo estudios',
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idTformacion',
                            bind: {
                                store: '{tiposFormacion}'
                            }
                        }, {
                            xtype: 'combo',
                            name: 'idEestudio',
                            fieldLabel: 'Estado estudios',
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idEestudio',
                            bind: {
                                store: '{estadosFormacion}'
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'institucion',
                            fieldLabel: 'Institución',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textareafield',
                            name: 'descripcion',
                            allowBlank: true,
                            fieldLabel: 'descripcion',
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
                        click: 'onSaveFormacion'
                    }
                }]
        }]

});

