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
                                rawValue: '{recordObra.etapa}',
                                value: '{recordObra.idEproceso}'
                            },
                            emptyText: 'Seleccionar',
                            forceSelection: true,
                            editable: false,
                            listeners: {
                                select: function (picker, record) {
                                    picker.up('window').getViewModel().set('selectEtapaProceso', record);
                                }
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Trabajador',
                            hideTrigger: true,
                            width: 356
                        }, {
                            xtype: 'datefield',
                            fieldLabel: 'Programación'
                        }]
                }]
        }, {

        }]
});