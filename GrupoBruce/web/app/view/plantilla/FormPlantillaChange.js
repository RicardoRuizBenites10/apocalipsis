Ext.define('GrupoBruce.view.plantilla.FormPlantillaChange', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformplantillachange',
    reference: 'form_plantillachange',
    id: 'id_wformplantillachange',

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
            id: 'id_gridesp',
            selModel: {
                type: 'checkboxmodel',
                mode: 'SIMPLE',
                checkOnly: false,
                ignoreRightMouseSelection: true
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
            dockedItems: [{
                    xtype: 'toolbar',
                    overflowHandler: 'menu',
                    items: [{
                            xtype: 'checkbox',
                            reference: 'filterCategoria',
                            boxLabel: 'Categorias',
                            checked: true,
                            listeners: {
                                change: 'changeCheckEsp'
                            }
                        }, {
                            xtype: 'treepicker',
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