Ext.define('GrupoBruce.view.periodovacacion.FormPeriodoVacacion', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformPeriodoVacacion',
    reference: 'form_periodoVacacion',

    controller: 'CperiodoVacacion',
    viewModel: {
        type: 'VMperiodoVacacion'
    },

    width: 350,
    autoShow: true,
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
                            xtype: 'numberfield',
                            name: 'idPVacacion',
                            allowDecimals: false,
                            hideTrigger: true,
                            minValue: 2000,
                            maxValue: 2100,
                            fieldLabel: 'Año',
                            bind: '{anio}'
                        }]
                }, {
                    items: [ {
                            xtype: 'datefield',
                            name: 'limInicio',
                            fieldLabel: 'Inicio de periodo',
                            format: 'd/m/Y',
                            flex: 1,
                            bind: '{limiteI}'
                        },{
                            xtype: 'datefield',
                            name: 'limFin',
                            fieldLabel: 'Fin de periodo',
                            format: 'd/m/Y',
                            flex: 1,
                            bind: '{limiteS}'
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
                        click: 'onSavePVacacion'
                    }
                }]
        }]
});