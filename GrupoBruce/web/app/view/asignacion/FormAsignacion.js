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
                            fieldLabel: 'Fecha'
                        }]
                }, {
                    items: [{
                            xtype: 'combo',
                            name: 'idRecepcionador',
                            displayField: 'apellidos',
                            valueField: 'idTrabajador',
                            fieldLabel: 'Custodio'
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nroIp',
                            fieldLabel: 'Dirección IP'
                        }, {
                            xtype: 'textfield',
                            name: 'nomUsu',
                            fieldLabel: 'Nombre usuario'
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nroIp',
                            fieldLabel: 'Contraseña'
                        }, {
                            xtype: 'textfield',
                            name: 'nomUsu',
                            fieldLabel: 'Repetir contraseña'
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