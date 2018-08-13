Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',

    store: {
        type: 'Strabajador'
    },
//    pageSize: 15,

    columns: [
        {text: 'Código', dataIndex: 'idTrabajador'},
        {text: 'Nombres', dataIndex: 'montoPasaje', flex: 1},
        {text: 'Carrera', dataIndex: 'montoBase', flex: 1}
    ],

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros"
        }]

});