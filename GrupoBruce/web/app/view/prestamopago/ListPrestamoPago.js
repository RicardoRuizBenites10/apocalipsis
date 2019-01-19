Ext.define('GrupoBruce.view.prestamopago.ListPrestamoPago',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistPrestamoPago',
    reference: 'list_prestamoPago',
    id: 'id_wprestamopago',

    bind: {
        store: '{prestamosPago}',
        selection: '{selectPrestamoPago}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idPrestamoPago',
            align: 'center'
        }, {
            text: 'Fecha',
            dataIndex: 'fecha',
            align: 'center'
        }, {
            text: 'Monto',
            dataIndex: 'monto'
        }, {
            text: 'Boleta'
        }],

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{prestamosPago}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});