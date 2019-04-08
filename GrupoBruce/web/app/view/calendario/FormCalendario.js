Ext.define('GrupoBruce.view.calendario.FormCalendario', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformCalendario',
    reference: 'form_calendario',

    controller: 'Ccalendario',
    viewModel: {
        type: 'VMcalendario'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar horario laboral',
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
                            xtype: 'datefield',
                            name: 'fecha',
                            fieldLabel: 'Fecha'
                        }]
                },{
                    items: [{
                            xtype: 'textarea',
                            name: 'descripcion',
                            allowBlank: true,
                            fieldLabel: 'Descripcion',
                            flex: 1
                    }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'libre',
                            reference: 'chk_cerrado',
                            boxLabel: 'Cerrado',
                            flex: 1
                        },{
                            xtype: 'checkbox',
                            name: 'refrigerio',
                            disabled: false,
                            bind: {
                                disabled: '{chk_cerrado.checked}'
                            },
                            reference: 'chk_refrigerio',
                            boxLabel: 'Refrigerio',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'timefield',
                            name: 'horaEntrada',
                            fieldLabel: 'Hora marcación',
                            minValue: '7:30 am',
                            maxValue: '6:00 pm',
                            increment: 10,
                            disabled: false,
                            bind: {
                                disabled: '{chk_cerrado.checked}'
                            },
                            flex: 1
                        }, {
                            xtype: 'timefield',
                            name: 'horaSalida',
                            fieldLabel: 'Hora marcación',
                            minValue: '7:30 am',
                            maxValue: '6:00 pm',
                            increment: 10,
                            disabled: false,
                            bind: {
                                disabled: '{chk_cerrado.checked}'
                            },
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
                        click: 'onSaveCalendario'
                    }
                }]
        }]
});