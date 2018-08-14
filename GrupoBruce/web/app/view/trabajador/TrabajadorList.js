Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',

    store: {
        type: 'Strabajador'
    },
    
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
            emptyMsg: "No hay registros",
            pageSize: 30
        }],

    tbar: [{
            text: 'Nuevo',
            iconCls: 'fa fa-plus',
            listeners: {
                click: 'nuevoTrabajador'
            }
        }, {
            text: 'Editar',
            iconCls: 'fa fa-edit',
            listeners: {
                click: 'editarTrabajador'
            }
        }, '-', {
            text: 'Ver',
            iconCls: 'fa fa-search',
            listeners: {
                click: 'verTrabajador'
            }
        }]

});