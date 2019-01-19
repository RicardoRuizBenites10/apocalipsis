Ext.define('GrupoBruce.view.prestamo.ListPrestamo',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistPrestamo',
    reference: 'list_prestamo',
    id: 'id_wlistprestamo',
    
    bind: {
        store: '{prestamos}',
        selection: '{selectPrestamo}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idPrestamo',
            align: 'center',
            width: 150
        }, {
            text: 'Fecha',
            dataIndex: 'fechaEntrega',
            formatter: 'date("d/m/Y")',
            align: 'center'
        }, {
            text: 'Prestado',
            dataIndex: 'mprestado'
        }, {
            text: 'Pagado',
            dataIndex: 'mpagado'
        }, {
            text: 'Estado',
            dataIndex: 'pagado',
            width: 150,
            align: 'center',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> PAGADO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> PENDIENTE </span>';
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
                    disabled: '{selectPrestamo}'
                },
                handler: 'addPrestamo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectPrestamo}' && '{!selectPrestamo.mpagado}'
                },
                handler: 'editPrestamo'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectPrestamo}' && '{!selectPrestamo.mpagado}'
                },
                handler: 'deletePrestamo'
            }, '-', {
                iconCls: 'x-fa fa-retweet',
                disabled: true,
                text: 'Pagos de prestamo',
                bind: {
                    disabled: '{!selectPrestamo}'
                },
                handler: 'onPagosPrestamo'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{prestamos}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});