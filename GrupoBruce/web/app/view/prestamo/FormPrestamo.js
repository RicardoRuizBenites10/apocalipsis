Ext.define('GrupoBruce.view.prestamo.FormPrestamo', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformPrestamo',
    reference: 'form_prestamo',

    controller: 'Cprestamo',
    viewModel: {
        type: 'VMprestamo'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar prestamo',
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
                            name: 'fechaEntrega',
                            fieldLabel: 'Fecha entrega',
                            format: 'd/m/Y',
                            bind: '{hoy}'
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'descripcion',
                            fieldLabel: 'Descripción',
                            allowBlank: true,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            name: 'mprestado',
                            hideTrigger: true,
                            minValue: 1,
                            fieldLabel: 'Monto prestamo',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            name: 'pagoCuota',
                            hideTrigger: true,
                            minValue: 1,
                            fieldLabel: 'Monto cuota',
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
                        click: 'onSavePrestamo'
                    }
                }]
        }]
});