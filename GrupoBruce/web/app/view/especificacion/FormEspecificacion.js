Ext.define('GrupoBruce.view.especificacion.FormEspecificacion', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformespecificacion',
    reference: 'form_especificacion',
    id: 'id_wformespecificacion',

    requires: [
        'GrupoBruce.view.especificacionactividad.EspecificacionActividad'
    ],
    
    controller: 'Cespecificacion',
    viewModel: {
        type: 'VMespecificacion'
    },

    dialog: true,
    closable: false,
    autoShow: true,
    width: 500,
    title: 'Editar Especificación',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 10
                }
            },
            items: [{
                    xtype: 'tabpanel',
                    items: [{
                            defaults: {
                                xtype: 'container',
                                layout: 'hbox',
                                defaults: {
                                    allowBlank: false,
                                    labelAlign: 'top',
                                    padding: 10
                                }
                            },
                            title: 'Datos generales',
                            items: [{
                                    items: [{
                                            xtype: 'treepicker',
                                            id: 'id_treecategoria',
                                            fieldLabel: 'Categoría',
                                            displayField: 'nombre',
                                            valueField: 'idEcategoria',
                                            bind: {
                                                store: '{especificacioncategorias}',
                                                value: '{miCodex}'
                                            },
                                            flex: 1
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'textarea',
                                            fieldLabel: 'Nombre',
                                            name: 'descripcion',
                                            flex: 1
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'checkbox',
                                            reference: 'chk_situacionespecificacion',
                                            fieldLabel: 'Situación',
                                            boxLabel: 'Activo'
                                        }]
                                }]
                        }, {
                            title: 'Actividades asignadas',
                            items: [{
                                    xtype: 'Wespecificacionactividad'
                                }]
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
                        click: 'onSaveEspecificacion'
                    }
                }]
        }]
});