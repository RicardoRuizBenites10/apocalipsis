Ext.define('GrupoBruce.view.concepto.ListConcepto', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistConcepto',
    reference: 'list_concepto',
    id: 'id_wlistconcepto',

    bind: {
        store: '{conceptos}',
        selection: '{selectConcepto}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idConcepto',
            width: 150,
            align: 'left'
        }, {
            text: 'Descripcion',
            dataIndex: 'descripcion',
            width: 350,
            align: 'left'
        }, {
            text: 'T.Concepto',
            dataIndex: 'tconcepto',
            align: 'left'
        }, {
            text: 'T.Variable',
            dataIndex: 'tvariable',
            align: 'left'
        }, {
            text: 'Estado',
            dataIndex: 'situacion',
            width: 150,
            align: 'center',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            }
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'combobox',
                fieldLabel: 'Tipo trabajador',
                displayField: 'descripcion',
                valueField: 'idTipo',
                bind: {
                    store: '{tiposTrabajador}',
                    selection: '{selectTipoTrabajador}'
                },
                editable: false,
                emptyText: 'Seleccionar..'
            }, {
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                disabled: false,
                bind: {
                    disabled: '{allowNuevo}'
                },
                handler: 'addConcepto'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectConcepto}'
                },
                handler: 'editConcepto'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectConcepto}'
                },
                handler: 'deleteConcepto'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{conceptos}'
            },
            displayInfo: true
        }]
});