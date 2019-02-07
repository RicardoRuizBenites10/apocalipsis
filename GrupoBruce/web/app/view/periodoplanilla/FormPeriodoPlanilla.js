Ext.define('GrupoBruce.view.periodoplanilla.FormPeriodoPlanilla', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformPeriodoPlanilla',
    reference: 'form_periodoPlanilla',

    controller: 'Cperiodoplanilla',
    viewModel: {
        type: 'VMperiodoplanilla'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar periodo planilla',
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
                            name: 'inicio',
                            fieldLabel: 'Inicio',
                            bind: '{finicio}',
                            flex: 1
                        }, {
                            xtype: 'datefield',
                            name: 'fin',
                            fieldLabel: 'Fin',
                            bind: '{ffin}',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'iniPlame',
                            fieldLabel: 'Inicio plame',
                            bind: '{limiteIP}',
                            flex: 1
                        }, {
                            xtype: 'datefield',
                            name: 'finPlame',
                            fieldLabel: 'Fin plame',
                            bind: '{limiteFP}',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            name: 'diasPeriodo',
                            hideTrigger: true,
                            editable: false,
                            fieldLabel: 'Días perido',
                            minValue: 0,
                            bind: '{diasPeriodo}'
                        }, {
                            xtype: 'checkbox',
                            name: 'cerrado',
                            reference: 'chk_cerradoPeriodoPlanilla',
                            fieldLabel: 'Estado',
                            boxLabel: 'Cerrado'
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
                        click: 'onSavePeriodoPlanilla'
                    }
                }]
        }]

});