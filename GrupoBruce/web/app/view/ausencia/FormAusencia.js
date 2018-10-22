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
                            maxRows: 3,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            reference: 'tiempo_ausencia',
                            name: 'idTmausencia',
                            fieldLabel: 'Tiempo ausencia',
                            emptyText: 'Seleccionar',
                            displayField: 'descripcion',
                            valueField: 'idTmausencia',
                            bind: {
                                store: '{tiemposAusencia}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'fechaInicio',
                            fieldLabel: 'Empezado desde'
                        }, {
                            xtype: 'datefield',
                            name: 'fechaFin',
                            fieldLabel: 'Acabado en'
                        }]
                }, {
                    items: [{
                            xtype: 'timefield',
                            name: 'horaInicio',
                            fieldLabel: 'Hora inicio',
                            hidden: true,
                            bind: {
                                hidden: '{!tiempo_ausencia.soloHoras}'
                            }
                        }, {
                            xtype: 'timefield',
                            name: 'horaFin',
                            fieldLabel: 'Hora fin',
                            hidden: true,
                            bind: {
                                hidden: '{!tiempo_ausencia.soloHoras}'
                            }
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


