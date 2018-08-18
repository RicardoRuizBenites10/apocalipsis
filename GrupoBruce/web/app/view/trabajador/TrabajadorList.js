Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',

    store: {
        type: 'Strabajador'
    },

    plugins: 'gridfilters',

    columns: [
        {
            text: 'DNI',
            dataIndex: 'idTrabajador',
            sortable: true,
            filter: {
                type: 'string'
            }
        }, 
        {
            text: 'A. Paterno', dataIndex: 'persona.apPaterno',
            xtype: 'templatecolumn', tpl: '{persona.apPaterno}',
            align: 'left'}, 
        {
            text: 'A. Materno', dataIndex: 'persona.apMaterno',
            xtype: 'templatecolumn', tpl: '{persona.apMaterno}',
            align: 'left'}, 
        {
            text: 'Nombres', dataIndex: 'persona.nombres',
            xtype: 'templatecolumn', tpl: '{persona.nombres}',
            align: 'left'},
        {text: 'Teléfono', xtype: 'templatecolumn', tpl: '{persona.telefono}'},
        {text: 'Dirección', xtype: 'templatecolumn', tpl: '{persona.direccion}', flex: 2, align: 'left'},
        {text: 'Tipo', xtype: 'templatecolumn', tpl: '{tipoTrabajador.descripcion}', align: 'center'},
        {text: 'Estado', xtype: 'templatecolumn', tpl: '{estadoTrabajador.descripcion}'}
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
        headerclick: 'onHeaderClick',
        select: 'onItemSelected'
    }

});