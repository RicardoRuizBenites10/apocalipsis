Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',

    store: {
        type: 'Strabajador'
    },
    
    columns: [
        {text: 'DNI', dataIndex: 'idTrabajador'},
        {text: 'Apellidos y Nombres', dataIndex: 'persona.apMaterno', flex: 2},
        {text: 'Teléfono', dataIndex: 'montoBase' },
        {text: 'Dirección', dataIndex: 'montoBase', flex: 2},
        {text: 'Tipo', dataIndex: 'montoBase' },
        {text: 'Estado', dataIndex: 'persona' }
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