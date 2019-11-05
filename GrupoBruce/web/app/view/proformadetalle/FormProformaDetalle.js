Ext.define('GrupoBruce.view.proformadetalle.FormProformaDetalle', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformproformadetalle',
    reference: 'form_proformadetalle',
    id: 'id_wformproformadetalle',

    controller: 'Cproformadetalle',
    viewModel: {
        type: 'VMproformadetalle'
    },

    modal: true,
    autoShow: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Asignar especificacion',
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
                            fieldLabel: 'Categoría',
                            valueField: 'idEcategoria',
                            displayField: 'nombre',
                            bind: {
                                store: '{categorias}'
                            },
                            emptyText: 'Seleccionar',
                            editable: false,
                            listeners: {
                                select: function (picker, record) {
                                    picker.up('window').getViewModel().set('selectCategoria', record);
                                }
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idEspecificacion',
                            fieldLabel: 'Especificación',
                            displayField: 'descripcion',
                            valueField: 'idEspecificacion',
                            bind: {
                                store: '{especificacions}',
                                selection: '{selectEspecificacion}'
                            },
                            forceSelection: true,
                            emptyText: 'Seleccionar',
                            pageSize: true,
                            minChars: 3,
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
                        click: 'onSaveProformaDetalle'
                    }
                }]
        }]
});