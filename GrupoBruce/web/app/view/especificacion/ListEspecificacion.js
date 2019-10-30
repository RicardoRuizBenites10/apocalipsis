Ext.define('GrupoBruce.view.especificacion.ListEspecificacion', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistespecificacion',
    reference: 'list_especificacion',
    id: 'id_wlistespecificacion',

//    requires: [
//        'Ext.grid.feature.Grouping'
//    ],

    bind: {
        store: '{especificacions}',
        selection: '{selectEspecificacion}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Nombre',
            dataIndex: 'descripcion',
            align: 'left',
            width: 600
        }, {
            text: 'Categoría',
            dataIndex: 'categoria',
            align: 'left',
            width: 150
        }, {
            text: 'Situacion',
            dataIndex: 'situacion',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            },
            align: 'center'
        }],

//    features: [{
//            ftype: 'grouping',
//            startCollapsed: true,
//            groupHeaderTpl: '{columnName}: {name}   ({rows.length} Item{[values.rows.length > 1 ? "s" : ""]})'
//        }],

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
                },'-',{
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectEspecificacion}'
                    },
                    handler: 'addEspecificacion'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectEspecificacion}'
                    },
                    handler: 'editEspecificacion'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectEspecificacion}'
                    },
                    handler: 'deleteEspecificacion'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{especificacions}'
            }
        }]

});