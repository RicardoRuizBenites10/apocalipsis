Ext.define('GrupoBruce.view.tipotrabajador.FormTipoTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformTipoTrabajador',
    reference: 'form_tipoTrabajador',

    controller: 'Ctipotrabajador',
    viewModel: {
        type: 'VMtipotrabajador'
    },

    modal: true,
    closable: true,
    resizable: true,

    width: 400,

    title: 'Editar tipo trabajador',
    items: [{
            xtype: 'form',
            defaults: {
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
                            name: 'idTtrabajador',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'descripcion',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            reference: 'chk_rpensionario',
                            name: 'hasrpensionario',
                            fieldLabel: 'R.Pensionario',
                            boxLabel: 'Si',
                            flex: 1
                        }, {
                            xtype: 'checkbox',
                            reference: 'chk_ctacts',
                            name: 'hasctacts',
                            fieldLabel: 'CTS',
                            boxLabel: 'Si',
                            flex: 1
                        }, {
                            xtype: 'checkbox',
                            reference: 'chk_jornaldiario',
                            name: 'jornalDiario',
                            fieldLabel: 'Jornal diario',
                            boxLabel: 'Si',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'numberfield',
                            hideTrigger: true,
                            minValue: 0,
                            name: 'pension',
                            fieldLabel: 'Pensión',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            hideTrigger: true,
                            minValue: 0,
                            name: 'essalud',
                            fieldLabel: 'Essalud',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            hideTrigger: true,
                            minValue: 0,
                            name: 'vida',
                            fieldLabel: 'Vida',
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
                        click: 'onSaveTipoTrabajador'
                    }
                }]
        }]
});