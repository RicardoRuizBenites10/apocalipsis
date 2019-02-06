Ext.define('GrupoBruce.view.concepto.FormConcepto', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformConcepto',
    reference: 'form_concepto',

    controller: 'Cconcepto',
    viewModel: 'VMconcepto',

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

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
                            xtype: 'combobox',
                            name: 'idTconcepto',
                            fieldLabel: 'Tipo concepto',
                            displayField: 'descripcion',
                            valueField: 'idTipo',
                            bind: {
                                store: '{tiposConcepto}',
                                selection: '{selectTipoConcepto}'
                            },
                            pageSize: true,
                            editable: false,
                            emptyText: 'Seleccionar',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idTplanilla',
                            fieldLabel: 'Tipo planilla',
                            displayField: 'descripcion',
                            valueField: 'idTipo',
                            bind: {
                                store: '{tiposPlanilla}',
                                selection: '{selectTipoPlanilla}'
                            },
                            pageSize: true,
                            editable: false,
                            emptyText: 'Seleccionar',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idTvariable',
                            fieldLabel: 'Tipo variable',
                            displayField: 'descripcion',
                            valueField: 'idTipo',
                            bind: {
                                store: '{tiposVariable}',
                                selection: '{selectTipoVariable}'
                            },
                            pageSize: true,
                            editable: false,
                            emptyText: 'Seleccionar',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'idConcepto',
                            fieldLabel: 'Código',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'descripcion',
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'formula',
                            fieldLabel: 'Fórmula',
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
                        click: 'onSaveConcepto'
                    }
                }]
        }]
});