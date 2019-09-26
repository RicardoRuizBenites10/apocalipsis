Ext.define('GrupoBruce.view.actividad.FormActividad', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformActividad',
    reference: 'form_actividad',

    requires: [
        'GrupoBruce.view.actividadmaterial.ActividadMaterial'
    ],

    controller: 'Cactividad',
    viewModel: {
        type: 'VMactividad'
    },

    width: 400,
    modal: true,
    closable: false,
    resizable: false,
    title: 'Editar actividad',

    items: [{
            xtype: 'form',
            items: [{
                    xtype: 'tabpanel',
                    items: [{
                            defaults: {
                                xtype: 'container',
                                layout: 'hbox',
                                defaults: {
                                    allowBlank: false,
                                    labelAlign: 'top',
                                    padding: 10
                                }
                            },
                            title: 'Datos generales',
                            items: [{
                                    items: [{
                                            xtype: 'treepicker',
                                            id: 'id_treeetapa',
                                            fieldLabel: 'Área',
                                            valueField: 'idEproceso',
                                            displayField: 'descripcion',
                                            bind: {
                                                store: '{eprocesos}',
                                                value: '{miCodex}'
                                            },
                                            emptyText: 'Seleccionar',
                                            forceSelection: true,
                                            editable: false,
                                            flex: 2
                                        }, {
                                            xtype: 'combobox',
                                            name: 'idMoneda',
                                            fieldLabel: 'Moneda',
                                            valueField: 'idMoneda',
                                            displayField: 'descripcion',
                                            bind: {
                                                store: '{monedas}',
                                                selection: '{selectMoneda}'
                                            },
                                            emptyText: 'Seleccionar',
                                            forceSelection: true,
                                            editable: false,
                                            flex: 1
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'textarea',
                                            name: 'nombre',
                                            fieldLabel: 'Nombre',
                                            flex: 1
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'numberfield',
                                            name: 'duracion',
                                            fieldLabel: 'Duración',
                                            minValue: 0,
                                            hideTrigger: true,
                                            width: '48%'
                                        }, {
                                            xtype: 'checkbox',
                                            name: 'situacion',
                                            reference: 'chk_situacionactividad',
                                            fieldLabel: 'Situacion',
                                            boxLabel: 'Activo',
                                            flex: 1
                                        }]
                                }]
                        }, {
                            title: 'Materiales a utilizar',
                            items: [{
                                    xtype: 'Wactividadmaterial'
                                }]
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
                        click: 'onSaveActividad'
                    }
                }]
        }]
});