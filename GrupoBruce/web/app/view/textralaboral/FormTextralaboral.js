Ext.define('GrupoBruce.view.textralaboral.FormTextralaboral', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformTextralaboral',
    reference: 'form_textralaboral',

    controller: 'Ctextralaboral',
    viewModel: {
        type: 'VMtextralaboral'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 500,

    title: 'Editar proceso',
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
                            xtype: 'combo',
                            id: 'id_trabajador_hextra',
                            name: 'idTrabajador',
                            valueField: 'idTrabajador',
                            displayField: 'nombres',
                            fieldLabel: 'Trabajador',
                            emptyText: 'Buscar..',
                            bind: {
                                store: '{trabajadors}',
                                selection: '{selectTrabajador}'
                            },
                            tpl: [
                                '<ul class="x-list-plain">',
                                '<tpl for=".">',
                                '<li class="',
                                Ext.baseCSSPrefix, 'grid-group-hd ', Ext.baseCSSPrefix, 'grid-group-title">DNI : {idTrabajador}</li>',
                                '<li class="x-boundlist-item">',
                                '{nombresCompletos} ',
                                '</li>',
                                '</tpl>',
                                '</ul>'
                            ],
                            minChars: 3,
                            pageSize: true,
                            hideTrigger: true,
                            triggerAction: 'query',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combo',
                            id: 'id_actividad_hextra',
                            name: 'idActividad',
                            valueField: 'idActividad',
                            displayField: 'nombre',
                            fieldLabel: 'Actividad',
                            emptyText: 'Buscar..',
                            bind: {
                                store: '{actividads}',
                                selection: '{selectActividad}'
                            },
                            tpl: [
                                '<ul class="x-list-plain">',
                                '<tpl for=".">',
                                '<li class="x-boundlist-item">',
                                '{nombre} ',
                                '</li>',
                                '</tpl>',
                                '</ul>'
                            ],
                            minChars: 3,
                            pageSize: true,
                            hideTrigger: true,
                            triggerAction: 'query',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combo',
                            name: 'idTtextra',
                            fieldLabel: 'Tipo',
                            bind: {
                                store: '{tiposTextra}'
                            },
                            displayField: 'descripcion',
                            valueField: 'idTtextra',
                            emptyText: 'Seleccionar..',
                            editable: false,
                            flex: 1
                        }, {
                            xtype: 'datefield',
                            name: 'fecha',
                            fieldLabel: 'Fecha programada',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'timefield',
                            name: 'horaInicio',
                            fieldLabel: 'Hora inicio',
                            minValue: '7:30 AM',
                            flex: 1
                        }, {
                            xtype: 'numberfield',
                            allowDecimals: false,
                            hideTrigger: true,
                            minValue: 1,
                            fieldLabel: 'Nro horas',
                            reference: 'hrs_extra',
                            id: 'id_hrs_extra',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'descripcion',
                            fieldLabel: 'Observación',
                            allowBlank: true,
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
                        click: 'onSaveTextralaboral'
                    }
                }]
        }]
});