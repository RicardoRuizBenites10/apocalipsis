Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',

    store: {
        type: 'Strabajador'
    },
    
    columns: [
        {text: 'DNI', dataIndex: 'codigo'},
        {text: 'Apellidos y Nombres', dataIndex: 'nombres', flex: 2},
        {text: 'Teléfono', dataIndex: 'profecion' },
        {text: 'Dirección', dataIndex: 'edad', flex: 2},
        {text: 'Tipo', dataIndex: 'estado' },
        {text: 'Estado', dataIndex: 'dni' }
    ],

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
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
        }],
    
    listeners: {
        select: 'onItemSelected'
    }
    
});