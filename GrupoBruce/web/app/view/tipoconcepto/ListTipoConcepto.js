Ext.define('GrupoBruce.view.tipoconcepto.ListTipoConcepto', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistTipoConcepto',
    reference: 'list_tipoConcepto',
    id: 'id_wlisttipoconcepto',

    bind: {
        store: '{tiposConcepto}',
        selection: '{selectTipoConcepto}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idTipo',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'descripcion',
            width: 400,
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
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectTipoConcepto}'
                },
                handler: 'addTipoConcepto'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectTipoConcepto}'
                },
                handler: 'editTipoConcepto'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectTipoConcepto}'
                },
                handler: 'deleteTipoConcepto'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{tiposConcepto}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});