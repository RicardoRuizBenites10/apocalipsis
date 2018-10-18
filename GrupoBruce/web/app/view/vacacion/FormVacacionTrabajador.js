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
//                            name: 'idPVacacion',
                            editable: false,
                            emptyText: 'Seleccionar',
                            fieldLabel: 'Periodo',
                            bind: {
                                store: '{periodos}'
                            },
                            displayField: 'idPVacacion',
                            valueField: 'idPVacacion'
                        }]
                },{
                    items: [{
                            xtype: 'checkbox',
                            name: 'parcial',
                            reference: 'check_parcial',
                            boxLabel: 'Parciales'
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Dias a tomar',
                            hidden: true,
                            bind: {
                                hidden: '{!check_parcial.checked}'
                            },
                            allowBlank: true
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            fieldLabel: 'Fecha inicio',
                            reference: 'fecha_salida',
                            name: 'fechaSalida',
                            format: 'd/m/Y',
                            minValue: new Date()
                        }, {
                            xtype: 'datefield',
                            fieldLabel: 'Fecha retorno',
                            name: 'fechaRetorno',
                            format: 'd/m/Y'
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