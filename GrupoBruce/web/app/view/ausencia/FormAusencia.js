Ext.define('GrupoBruce.view.ausencia.FormAusencia', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformAusencia',
    reference: 'form_ausencia',

    bind: {
        title: '{title}'
    },
    width: 370,
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
                            xtype: 'combobox',
                            name: 'idTausencia',
                            fieldLabel: 'Tipo ausencia',
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
                            format: 'd/m/Y'
                        }, {
                            xtype: 'datefield',
                            name: 'fechaFin',
                            fieldLabel: 'Acabado en',
                            format: 'd/m/Y'
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
                            maxValue: '4:30 PM'
                        }, {
                            xtype: 'timefield',
                            name: 'horaFin',
                            fieldLabel: 'Hora fin',
                            disabled: true,
                            bind: {
                                disabled: '{selectTiempo ? !selectTiempo.horas : true}'
                            },
                            minValue: '7:30 AM',
                            maxValue: '4:30 PM'
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


