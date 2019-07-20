Ext.define('GrupoBruce.view.contratista.FormContratista', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformcontratista',
    reference: 'form_contratista',
    id: 'id_wformcontratista',

    controller: 'Ccontratista',
    viewModel: {
        type: 'VMcontratista'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,
    title: 'Editar contratista',

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
                            name: 'idContratista',
                            fieldLabel: 'Nro. RUC',
                            hideTrigger: true,
                            minLength: 8,
                            maxLength: 15,
                            width: '48%',
                            bind: {
                                editable: '{newRegister}'
                            },
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'textfield',
                            name: 'nombre',
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'direccion',
                            fieldLabel: 'Dirección',
                            flex: 1
                    }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'telefono',
                            fieldLabel: 'Teléfono',
                            allowBlank: true,
                            flex: 1
                    },{
                            xtype: 'textfield',
                            name: 'correo',
                            fieldLabel: 'Correo electronico',
                            allowBlank: true,
                            flex: 1
                    }]
                },{
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Área de producción',
                            name: 'idEproceso',
                            valueField: 'idEproceso',
                            displayField: 'descripcion',
                            bind: {
                                store: '{etapasproceso}',
                                selection: '{selectEtapaProceso}'
                            },
                            editable: false,
                            forceSelection: true,
                            emptyText: 'Seleccionar',
                            flex: 1
                    }]
                },{
                    items: [{
                            xtype: 'checkbox',
                            name:'situacion',
                            fieldLabel: 'Situacion',
                            boxLabel: 'Activo',
                            reference: 'chk_situacioncontratista'
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
                        click: 'onSaveContratista'
                    }
                }]
        }]
});