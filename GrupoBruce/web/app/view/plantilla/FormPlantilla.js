Ext.define('GrupoBruce.view.plantilla.FormPlantilla', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformplantilla',
    reference: 'form_plantilla',
    id: 'id_wformplantilla',

    controller: 'Cplantilla',
    viewModel: {
        type: 'VMplantilla'
    },

    modal: true,
    resizable: false,
    width: 600,
    autoShow: true,

    title: 'Especificaciones asignadas',
    items: [{
            xtype: 'grid',
            bind: {
                store: '{plantillas}'
            },
            flex: 1,
            height: 400,
            columns: [{
                    text: 'Categoría',
                    dataIndex: 'categoria'
                }, {
                    text: 'Especificación',
                    dataIndex: 'especificacion',
                    width: 380
                }, {
                    text: 'Actualización',
                    dataIndex: 'fechaUpdate',
                    formatter: 'date("d/m/Y")'
                }],
            dockedItems: [{
                    xtype: 'toolbar',
                    overflowHandler: 'menu',
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Modelo',
                            labelWidth: 50,
                            width: 150,
                            readOnly: true,
                            bind: {
                                value: '{recordCarroceria.idCarroceria}'
                            }
                        }, {
                            xtype: 'checkbox',
                            reference: 'filterCategoria',
                            boxLabel: 'Categorias',
                            checked: true,
                            listeners: {
                                change: 'changeCheckPT'
                            }
                        }, {
                            xtype: 'treepicker',
                            valueField: 'idEcategoria',
                            displayField: 'nombre',
                            bind: {
                                store: '{especificacioncategorias}',
                                disabled: '{!filterCategoria.checked}'
                            },
                            editable: false,
                            emptyText: 'Seleccionar',
                            labelAlign: 'right',
                            listeners: {
                                select: 'selectPicker'
                            }
                        }, {
                            text: 'Agregar/Quitar',
                            iconCls: 'x-fa fa-edit',
                            handler: 'onPlantillaChange'
                        }]
                }]
        }]

});