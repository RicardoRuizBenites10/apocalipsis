Ext.define('GrupoBruce.view.especificacionactividad.FormEspecificacionActividad', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformespecificacionactividad',
    reference: 'form_especificacionactividad',
    id: 'id_wformespecificacionactividad',

    controller: 'Cespecificacionactividad',
    viewModel: {
        type: 'VMespecificacionactividad'
    },

    modal: true,
    closable: false,
    width: 500,
    title: 'Editar actividad de especificación',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    padding: 10,
                    labelAlign: 'top'
                }
            },
            items: [{
                    items: [{
                            xtype: 'treepicker',
                            fieldLabel: 'Área',
                            valueField: 'idEproceso',
                            displayField: 'descripcion',
                            bind: {
                                store: '{etapaprocesos}'
                            },
                            editable: false,
                            emptyText: 'Seleccionar',
                            forceSelection: true,
                            flex: 1,
                            listeners: {
                                select: 'selectPicker'
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Actividad',
                            name: 'idActividad',
                            valueField: 'idActividad',
                            displayField: 'nombre',
                            bind: {
                                store: '{actividads}',
                                selection: '{selectActividad}'
                            },
                            emptyText: 'Seleccionar',
                            hideTrigger: true,
                            forceSelection: true,
                            minChars: 3,
                            pageSize: true,
                            triggerAction: 'query',
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
                        click: 'onSaveEspecificacionActividad'
                    }
                }]
        }]
});