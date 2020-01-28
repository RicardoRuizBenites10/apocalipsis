Ext.define('GrupoBruce.view.obraseguimiento.ObraSeguimiento', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.obraseguimiento.ObraSeguimientoController',
        'GrupoBruce.view.obraseguimiento.ObraSeguimientoModel',

        'GrupoBruce.view.obraseguimiento.ListObraSeguimiento'
    ],

    controller: 'Cobraseguimiento',
    viewModel: {
        type: 'VMobraseguimiento'
    },

    modal: true,
    resizable: false,
    closable: false,
    autoShow: true,
    width: 600,

    title: 'Seguimiento de Orden de Producción',
    items: [{
            xtype: 'form',
            items: [{
                    defaults: {
                        layout: 'hbox',
                        defaults: {
                            allowBlank: false,
                            labelAlign: 'top',
                            padding: 7
                        }
                    },
                    items: [{
                            items: [{
                                    xtype: 'textfield',
                                    name: 'nombre',
                                    fieldLabel: 'Orden de producción',
                                    bind: {
                                        value: '{recordObra.nombre}'
                                    },
                                    editable: false
                                }, {
                                    xtype: 'combobox',
                                    name: 'idEobra',
                                    fieldLabel: 'Situación',
                                    valueField: 'idEobra',
                                    displayField: 'nombre',
                                    bind: {
                                        store: '{estadoobras}',
                                        selection: '{selectEstadoObra}'
                                    },
                                    emptyText: 'Seleccionar',
                                    editable: false,
                                    forceSelection: true
                                }]
                        }]
                }, {
                    xtype: 'Wlistobraseguimiento',
                    height: 280
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
                        click: 'onSaveObraSeguimiento'
                    }
                }]
        }]
});
