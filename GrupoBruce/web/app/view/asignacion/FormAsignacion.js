Ext.define('GrupoBruce.view.asignacion.FormAsignacion', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformAsignacion',
    reference: 'form_asignacion',

    controller: 'Casignacion',
    viewModel: {
        type: 'VMasignacion'
    },

    modal: true,
    resizable: false,
    autoShow: true,
    width: 400,

    title: 'Editar asignación',
    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    padding: 5,
                    allowBlank: false
                }
            },
            items: [{
                    items: [{
                            xtype: 'datefield',
                            name: 'fecha',
                            fieldLabel: 'Inicio de asignación'
                        }]
                }, {
                    items: [{
                            xtype: 'combo',
                            name: 'idRecepcionador',
                            displayField: 'nombres',
                            valueField: 'idTrabajador',
                            fieldLabel: 'Custodio',
                            bind: {
                                store: '{trabajadors}'
                            },
                            tpl: [
                                '<ul class="x-list-plain">',
                                '<tpl for=".">',
                                '<li class="',
                                Ext.baseCSSPrefix, 'grid-group-hd ', Ext.baseCSSPrefix, 'grid-group-title">{idTrabajador}</li>',
                                '<li class="x-boundlist-item">',
                                '{apPaterno} {apMaterno}, {nombres}',
                                '</li>',
                                '</tpl>',
                                '</ul>'
                            ],
                            minChars: 0,
                            hideTrigger: true,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nroIp',
                            fieldLabel: 'Dirección IP'
                        }, {
                            xtype: 'textfield',
                            name: 'nomUsu',
                            fieldLabel: 'Nombre usuario',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'pasUsu',
                            inputType: 'password',
                            fieldLabel: 'Contraseña'
                        }, {
                            xtype: 'textfield',
                            inputType: 'password',
                            fieldLabel: 'Repetir contraseña',
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
                        click: 'onSaveAsignacion'
                    }
                }]
        }]
});