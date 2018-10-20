Ext.define('GrupoBruce.view.vacacion.FormVacacionTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformVacacionTrabajador',
    reference: 'form_vacacionTrabajador',

    width: 370,
    resizable: false,
    closable: false,
    modal: true,

    bind: {
        title: '{title}'
    },

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
                            name: 'idPVacacion',
                            editable: false,
                            emptyText: 'Seleccionar',
                            fieldLabel: 'Periodo',
                            bind: {
                                store: '{periodos}',
                                selection: '{selectPeriodo}'
                            },
                            displayField: 'idPVacacion',
                            valueField: 'idPVacacion'
                        },{
                            xtype: 'textfield',
                            fieldLabel: 'Tiempo servicio',
                            bind: '{tiempo_servicio}',
                            minValue: 1,
                            editable: false
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idTVacacion',
                            editable: false,
                            emptyText: 'Seleccionar',
                            fieldLabel: 'Tipo vacación',
                            bind: {
                                store: '{tipos}',
                                selection: '{selectTipo}'
                            },
                            autoSelect: true,
                            displayField: 'descripcion',
                            valueField: 'idTVacacion'
                        },{
                            xtype: 'numberfield',
                            name: 'diasTomados',
                            fieldLabel: 'Dias a tomar',
                            allowDecimals: false,
                            hideTrigger: true,
                            minValue: 7,
                            maxValue: 30,
                            hidden: true,
                            bind: {
                                hidden: '{selectTipo ? !selectTipo.pagar : true}',
                                value: '{nroDias}'
                            },
                            allowBlank: true
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            fieldLabel: 'Fecha inicio',
                            name: 'fechaSalida',
                            format: 'd/m/Y',
                            bind: '{salida}',
                            minValue: new Date()
                        }, {
                            xtype: 'datefield',
                            fieldLabel: 'Fecha retorno',
                            name: 'fechaRetorno',
                            format: 'd/m/Y',
                            bind: '{retorno}'
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
                        click: 'onSaveVacacion'
                    }
                }]
        }]

});