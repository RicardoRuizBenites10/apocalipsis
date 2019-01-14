Ext.define('GrupoBruce.view.marca.FormMarca', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformMarcacion',
    reference: 'form_marcacion',

    controller: 'Casistencia',
    viewModel: {
        type: 'VMasistencia'
    },

    width: 400,
    resizable: false,
    closable: false,
    modal: true,
    autoShow: true,
    title: 'Editar marcación',

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
                            xtype: 'textfield',
                            name: 'idTrabajador',
                            fieldLabel: 'Dni',
                            flex: 1
                        },{
                            xtype: 'textfield',
                            name: 'trabajador',
                            fieldLabel: 'Trabajador',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'fecha',
                            format: 'd/m/Y',
                            fieldLabel: 'Fecha'
                        }, {
                            xtype: 'timefield',
                            name: 'hmarca',
                            fieldLabel: 'Hora marcación',
                            minValue: '7:30 am',
                            maxValue: '4:30 pm',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            name: 'anio',
                            fieldLabel: 'Año',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            name: 'mes',
                            fieldLabel: 'Mes',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            name: 'dia',
                            fieldLabel: 'Día',
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
                        click: 'onSaveMarcacion'
                    }
                }]
        }]

});