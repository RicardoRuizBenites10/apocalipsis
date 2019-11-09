Ext.define('GrupoBruce.view.obra.FormObra', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformobra',
    reference: 'form_obra',
    id: 'id_wformobra',

    controller: 'Cobra',
    viewModel: {
        type: 'VMobra'
    },

    modal: true,
    autoShow: true,
    closable: false,
    resizable: false,
    width: 400,

    tiltle: 'Editar orden de producción',
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
                            xtype: 'combobox',
                            name: 'idObrtip',
                            fieldLabel: 'Tipo',
                            displayField: 'descripcion',
                            valueField: 'idObrtip',
                            bind: {
                                store: '{obratipos}',
                                selection: '{selectObraTipo}'
                            },
                            emptyText: 'Seleccionar',
                            editable: false,
                            forceSelection: true,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nombre',
                            fieldLabel: 'Número de OP'
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idProforma',
                            fieldLabel: 'Proforma',
                            displayField: 'idProforma',
                            valueField: 'idProforma',
                            bind: {
                                store: '{proformas}',
                                selection: '{selectProforma}'
                            },
                            emptyText: 'Seleccionar',
                            editable: false,
                            forceSelection: true,
                            flex: 1
                        }, {
                            xtype: 'textfield',
                            fieldLabel: 'Cliente',
                            bind: {
                                value: '{selectProforma.cliente}'
                            },
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'fechaInicio',
                            fieldLabel: 'Inicio programado:',
                            format: 'd/m/Y',
                            bind: '{currentDate}',
                            flex: 1
                        }, {
                            xtype: 'datefield',
                            name: 'fechaFin',
                            fieldLabel: 'Fin programado:',
                            format: 'd/m/Y',
                            bind: '{currentDate}',
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
                        click: 'onSaveObra'
                    }
                }]
        }]

});