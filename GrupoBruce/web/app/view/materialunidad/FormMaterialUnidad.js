Ext.define('GrupoBruce.view.materialunidad.FormMaterialUnidad', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformmaterialunidad',
    reference: 'form_materialunidad',
    id: 'id_wformmaterialunidad',

    controller: 'Cmaterialunidad',
    viewModel: {
        type: 'VMmaterialunidad'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 300,

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
                            name: 'idUmedida',
                            fieldLabel: 'Unidad medida',
                            valueField: 'idUmedida',
                            displayField: 'denominacion',
                            bind: {
                                store: '{unidadsmedida}',
                                selection: '{selectUnidadMedida}'
                            },
                            forceSelection: true,
                            editable: false,
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'numberfield',
                            name: 'equivalencia',
                            fieldLabel: 'Equivalencia',
                            hideTrigger: true,
                            bind: '{selectUnidadMedida.equivalencia}',
                            decimalPrecision: 5,
                            minValue: 0,
                            flex: 1
                    }]
                },{
                    items: [{
                            xtype: 'checkbox',
                            name: 'base',
                            reference: 'chk_unidadbase',
                            boxLabel: 'Unidad base',
                            bind: {
                                hidden: '{hasBase}'
                            }
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
                        click: 'onSaveMaterialUnidad'
                    }
                }]
        }]
});