Ext.define('GrupoBruce.view.ausencia.FormAusencia', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformAusencia',
    reference: 'form_ausencia',

    controller: 'Causencia',
    viewModel: {
        type: 'VMausencia'
    },

    width: 400,
    resizable: false,
    closable: false,
    modal: true,
    autoShow: true,
    title: 'Editar ausencia',

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
                            xtype: 'combobox',
                            name: 'idTausencia',
                            fieldLabel: 'Tipo ausencia',
                            editable: false,
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idTausencia',
                            bind: {
                                store: '{tiposAusencia}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textareafield',
                            name: 'detalle',
                            fieldLabel: 'Descripcion',
                            allowBlank: true,
//                            maxRows: 3,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idTmausencia',
                            fieldLabel: 'Tiempo ausencia',
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idTmausencia',
                            editable: false,
                            bind: {
                                store: '{tiemposAusencia}',
                                selection: '{selectTiempo}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'fechaInicio',
                            fieldLabel: 'Empezado desde',
                            format: 'd/m/Y',
                            flex: 1
                        }, {
                            xtype: 'datefield',
                            name: 'fechaFin',
                            fieldLabel: 'Acabado en',
                            format: 'd/m/Y',
                            flex: 1,
                            disabled: true,
                            bind: {
                                disabled: '{selectTiempo.horas}'
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'timefield',
                            name: 'horaInicio',
                            fieldLabel: 'Hora inicio',
                            disabled: true,
                            bind: {
                                disabled: '{selectTiempo ? !selectTiempo.horas : true}'
                            },
                            minValue: '7:30 AM',
                            maxValue: '4:30 PM',
                            flex: 1
                        }, {
                            xtype: 'timefield',
                            name: 'horaFin',
                            fieldLabel: 'Hora fin',
                            disabled: true,
                            bind: {
                                disabled: '{selectTiempo ? !selectTiempo.horas : true}'
                            },
                            minValue: '7:30 AM',
                            maxValue: '4:30 PM',
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
                        click: 'onSaveAusencia'
                    }
                }]

        }]
});


