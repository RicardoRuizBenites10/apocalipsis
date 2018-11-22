Ext.define('GrupoBruce.view.mantenimientoeinformatico.FormMantenimientoEinformatico', {
    extend: 'Ext.window.Window',
    alias: 'widget,WformMantenimientoEinformatico',
    reference: 'form_mantenimientoEinformatico',

    controller: 'Cmantenimientoeinformatico',
    viewModel: {
        type: 'VMmantenimientoeinformatico'
    },

    modal: true,
    resizable: false,
    autoShow: true,
    width: 400,

    title: 'Editar mantenimiento',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    allowBlank: false,
                    padding: 7
                }
            },
            items: [{
                    items: [{
                            xtype: 'datefield',
                            name: 'fechaProgramada',
                            fieldLabel: 'Fecha programada'
                        }, {
                            xtype: 'combobox',
                            name: 'idTmantenimiento',
                            fieldLabel: 'Tipo mantenimiento',
                            displayField: 'descripcion',
                            valueField: 'idTmantenimiento',
                            editable: false,
                            bind: {
                                store: '{tiposMantenimiento}',
                                selection: '{tipoMantenimiento}'
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'observacion',
                            fieldLabel: 'Observacion',
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
                        click: 'onSaveMantenimiento'
                    }
                }]
        }]
});