Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',

    store: {
        type: 'Strabajador'
    },
    
    columns: [
        {text: 'DNI', dataIndex: 'idTrabajador'},
        {text: 'Apellidos y Nombres', xtype: 'templatecolumn', tpl: '{persona.apPaterno} {persona.apMaterno}, {persona.nombres}' , flex: 2},
        {text: 'Teléfono', xtype: 'templatecolumn', tpl: '{persona.telefono}' },
        {text: 'Dirección', xtype: 'templatecolumn', tpl: '{persona.direccion}', flex: 2},
        {text: 'Tipo', xtype: 'templatecolumn', tpl: '{tipoTrabajador.descripcion}' },
        {text: 'Estado', xtype: 'templatecolumn', tpl: '{estadoTrabajador.descripcion}' }
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