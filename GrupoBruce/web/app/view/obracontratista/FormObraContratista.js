Ext.define('GrupoBruce.view.obracontratista.FormObraContratista', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformobracontratista',
    reference: 'form_obracontratista',
    id: 'id_wformobracontratista',

    controller: 'Cobracontratista',
    viewModel: {
        type: 'VMobracontratista'
    },

    modal: true,
    resizable: false,
    closable: false,
    autoShow: true,
    width: 400,

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 7
                }
            },
            items: [{
                    items: [{
                            xtype: 'treepicker',
                            fieldLabel: 'Área producción',
                            displayField: 'descripcion',
                            valueField: 'idEproceso',
                            name: 'idEproceso',
                            bind: {
                                store: '{etapaprocesos}',
                                rawValue: '{recordObra.etapa}'
                            },
                            emptyText: 'Seleccionar',
                            forceSelection: true,
                            editable: false,
                            flex: 1,
                            listeners: {
                                select: function (picker, record) {
                                    picker.up('window').getViewModel().set('selectEtapa', record);
                                }
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idContratista',
                            fieldLabel: 'Contratista',
                            displayField: 'nombre',
                            valueField: 'idContratista',
                            bind: {
                                store: '{contratistas}',
                                selection: '{selectContratista}'
                            },
                            emptyText: 'Seleccionar',
                            forceSelection: true,
                            hideTrigger: true,
                            triggerAction: 'query',
                            minChars: 3,
                            pageSize: true,
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
                        click: 'onSaveObraContratista'
                    }
                }]
        }]
});