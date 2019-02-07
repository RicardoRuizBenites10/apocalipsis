Ext.define('GrupoBruce.view.concepto.FormConcepto', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformConcepto',
    reference: 'form_concepto',

    controller: 'Cconcepto',
    viewModel: 'VMconcepto',

    modal: true,
    closable: false,
    resizable: false,
    width: 800,

    title: 'Editar proceso',
    layout: 'hbox',
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
                            editable: false,
                            emptyText: 'Seleccionar',
                            flex: 1
                        }, {
                            xtype: 'combobox',
                            name: 'idTvariable',
                            fieldLabel: 'Tipo variable',
                            displayField: 'descripcion',
                            valueField: 'idTipo',
                            bind: {
                                store: '{tiposVariable}',
                                selection: '{selectTipoVariable}'
                            },
                            editable: false,
                            emptyText: 'Seleccionar',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'codPdt',
                            fieldLabel: 'PDT',
                            allowBlank: true,
                            flex: 1
                        }, {
                            xtype: 'textfield',
                            name: 'idConcepto',
                            fieldLabel: 'Código',
                            flex: 4
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
                            reference: 'text_formula',
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
                }],
            flex: 2
        }, {
            xtype: 'grid',
            bind: {
                store: '{conceptos}',
                selection: '{selectFormula}'
            },
            allowDeselect: true,
            columns: [{
                    text: 'Código',
                    dataIndex: 'idConcepto',
                    align: 'left',
                    width: 175
                }, {
                    text: 'Descripción',
                    dataIndex: 'descripcion',
                    align: 'left',
                    width: 200
                }],
            tbar: {
                overflowHandler: 'menu',
                items: [{
                        iconCls: 'x-fa fa-angle-left',
                        text: 'Agregar',
                        disabled: true,
                        bind: {
                            disabled: '{!selectFormula}'
                        },
                        handler: 'onAddFormula'
                    },{
                        text: '+',
                        handler: 'onSuma'
                    },{
                        text: '-',
                        handler: 'onResta'
                    },{
                        text: 'x',
                        handler: 'onMultiplicacion'
                    },{
                        text: '/',
                        handler: 'onDivision'
                    },{
                        text: '(',
                        handler: 'onParAbierto'
                    },{
                        text: ')',
                        handler: 'onParCerrado'
                    }]
            },
            dockedItems: [{
                    xtype: 'pagingtoolbar',
                    dock: 'bottom',
                    bind: {
                        store: '{conceptos}'
                    },
                    displayInfo: true
                }],
            height: 380,
            flex: 2
        }]
});