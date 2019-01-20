Ext.define('GrupoBruce.view.concepto.ListConcepto',{
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
            width: 200,
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'descripcion',
            width: 350,
            align: 'left'
        }, {
            text: 'Tipo',
            align: 'left',
            width: 250
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
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectConcepto}'
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
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});