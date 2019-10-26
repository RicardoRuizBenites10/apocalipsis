Ext.define('GrupoBruce.view.plantilla.FormPlantillaChange', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformplantillachange',
    reference: 'form_plantillachange',
    id: 'id_formplantillachange',

    controller: 'Cplantilla',
    viewModel: {
        type: 'VMplantilla'
    },

    modal: true,
    closable: true,
    resizable: false,
    width: 600,
    autoShow: true,
    title: 'Lista de especificaciones',

    items: [{
            xtype: 'grid',
            selModel: {
                type: 'checkboxmodel',
                mode: 'SIMPLE',
                checkOnly: false,
                ignoreRightMouseSelection: true,
                renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                    console.log('ronron');
                }
            },

            bind: {
                store: '{especificacions}'
            },
            columnLines: true,
            height: 400,
            columns: [{
                    text: 'Categoría',
                    dataIndex: 'categoria',
                    align: 'left',
                    width: 150
                }, {
                    text: 'Especificación',
                    dataIndex: 'descripcion',
                    align: 'left',
                    width: 450
                }],
            listeners: {
                afterrender: function (grid, opts) {
                    console.log('dale bro');
//                    var store = grid.getStore(),selections = [];
//                    store.each(function (item) {
//                        if (item.get('asignado')) {
//                            selections.push(item);
//                        }
//                    });
//                    grid.getSelectionModel().select(selections);
                },
                refresh: function (view) {
                    console.log('dedal');
                }
            },
            dockedItems: [{
                    xtype: 'toolbar',
                    overflowHandler: 'menu',
                    items: [{
                            xtype: 'checkbox',
                            reference: 'filterCategoria',
                            boxLabel: 'Filtrar por categorias',
                            checked: true,
                            listeners: {
                                change: 'changeCheck'
                            }
                        }, {
                            xtype: 'treepicker',
                            fieldLabel: 'Categorias',
                            valueField: 'idEcategoria',
                            displayField: 'nombre',
                            bind: {
                                store: '{especificacioncategorias}',
                                hidden: '{!filterCategoria.checked}'
                            },
                            editable: false,
                            emptyText: 'Seleccionar',
                            labelAlign: 'right',
                            listeners: {
                                select: 'selectPicker'
                            }
                        }, '-', {
                            text: 'Guardar',
                            iconCls: 'x-fa fa-save',
                            handler: 'savePlantillaChange'
                        }]
                }]
        }]
});