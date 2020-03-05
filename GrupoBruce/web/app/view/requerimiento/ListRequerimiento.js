Ext.define('GrupoBruce.view.requerimiento.ListRequerimiento', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wlistrequerimiento',
    reference: 'list_requerimiento',
    id: 'id_wlistrequerimiento',

    controller: 'Crequerimiento',
    viewModel: {
        type: 'VMrequerimiento'
    },

    modal: true,
    closable: true,
    resizable: false,
    autoShow: true,

    width: 600,

    title: 'Requerimiento',
    items: [{
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    padding: 7
                }
            },
            items: [{
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'OP',
                            bind: '{recordObra.nombre}'
                        }, {
                            xtype: 'treepicker',
                            fieldLabel: 'Área',
                            valueField: 'idEproceso',
                            displayField: 'descripcion',
                            bind: {
                                store: '{eprocesos}',
                                value: '{recordObra.idEproceso}',
                                rawValue: '{recordObra.etapa}'
                            },
                            emptyText: 'Seleccionar',
                            forceSelection: true,
                            editable: false,
                            listeners: {
                                select: function (picker, record) {
                                    picker.up('window').getViewModel().set('selectEtapaProceso_id', record.get('idEproceso'));
                                }
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'fieldset',
                            title: 'Datos para programación',
                            margin: '0 8px 8px 8px',
                            defaults: {
                                layout: 'hbox',
                                defaults: {
                                    labelAlign: 'top',
                                    padding: 7
                                }
                            },
                            items: [{
                                    items: [{
                                            xtype: 'combobox',
                                            fieldLabel: 'Trabajador asignado',
                                            displayField: 'nombres',
                                            valueField: 'idTrabajador',
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
                                            width: 356
                                        }, {
                                            xtype: 'datefield',
                                            fieldLabel: 'Programación',
                                            value: new Date()
                                        }]
                                }]
                        }]
                }]
        }, {
            xtype: 'Wlistrequerimientoactividad',
            height: 300
        }]
});