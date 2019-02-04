Ext.define('GrupoBruce.view.horario.FormHorario', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformHorario',
    reference: 'form_horario',

    controller: 'Chorario',
    viewModel: 'VMhorario',

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
                            xtype: 'combobox',
                            name: 'idDia',
                            fieldLabel: 'Dia',
                            displayField: 'descripcion',
                            valueField: 'idDia',
                            emptyText: 'Seleccionar',
                            editable: false,
                            bind: {
                                store: '{dias}',
                                selection: '{selectDia}'
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'libre',
                            reference: 'chk_cerrado',
                            boxLabel: 'Cerrado',
                            flex: 1
                        }, {
                            xtype: 'checkbox',
                            name: 'refrigerio',
                            reference: 'chk_refrigerio',
                            disabled: false,
                            bind: {
                                disabled: '{chk_cerrado.checked}'
                            },
                            boxLabel: 'Se toma refrigerio',
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
                        click: 'onSaveHorario'
                    }
                }]
        }]

});