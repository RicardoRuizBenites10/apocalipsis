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
                            id: 'id_recepcionador',
                            reference: 'dodone',
                            name: 'idRecepcionador',
                            valueField: 'idTrabajador',
                            displayField: 'nombres',
                            fieldLabel: 'Custodio',
                            emptyText: 'Buscar..',
                            bind: {
                                store: '{trabajadors}',
                                selection: '{selectRecepcionador}'
                            },
                            tpl: [
                                '<ul class="x-list-plain">',
                                '<tpl for=".">',
                                '<li class="',
                                Ext.baseCSSPrefix, 'grid-group-hd ', Ext.baseCSSPrefix, 'grid-group-title">DNI : {idTrabajador}</li>',
                                '<li class="x-boundlist-item">',
                                '{nombresCompletos} ',
                                '</li>',
                                '</tpl>',
                                '</ul>'
                            ],
                            minChars: 1,
                            pageSize: true,
                            hideTrigger: true,
                            triggerAction: 'query',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nroIp',
                            fieldLabel: 'Dirección IP'
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nomUsu',
                            fieldLabel: 'Nombre usuario'
                        }, {
                            xtype: 'textfield',
                            name: 'pasUsu',
                            fieldLabel: 'Contraseña',
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