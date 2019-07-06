Ext.define('GrupoBruce.view.actividad.FormActividad', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformActividad',
    reference: 'form_actividad',

    controller: 'Cactividad',
    viewModel: {
        type: 'VMactividad'
    },

    width: 400,
    modal: true,
    closable: false,
    resizable: false,

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
                            xtype: 'textarea',
                            name: 'nombre',
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            name: 'duracion',
                            fieldLabel: 'Duración',
                            minValue: 0,
                            hideTrigger: true,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            fieldLabel: 'Uso de material',
                            boxLabel: 'Si',
                            flex: 1
                        }, {
                            xtype: 'checkbox',
                            fieldLabel: 'Situacion',
                            boxLabel: 'Activo',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'combobox',
                            name: 'idEproceso',
                            valueField: 'idEproceso',
                            displayField: 'descripcion',
                            bind: {
                                store: '{eprocesos}',
                                selection: '{selectEproceso}'
                            },
                            emptyText: 'Seleccionar',
                            forceSelection: true,
                            editable: false,
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
                        click: 'onSaveActividad'
                    }
                }]
        }]
});