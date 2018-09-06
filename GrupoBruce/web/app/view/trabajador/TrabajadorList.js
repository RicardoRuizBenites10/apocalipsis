Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    
    xtype: 'trabajadorList',

    store: {
        type: 'Strabajador'
    },

    plugins: [
        'gridfilters'
    ],

    style: 'border: solid rgb(234,234,236) 1px',

    columns: [
        {
            text: 'DNI', dataIndex: 'idTrabajador',
            align: 'left',
            filter: {type: 'string', value: ''}
        },
//        {
//            text: 'A. Paterno', dataIndex: 'persona.apPaterno',
//            xtype: 'templatecolumn', tpl: '{persona.apPaterno}',
//            width: 130, align: 'left'},
        {
            text: 'A. Paterno', dataIndex: 'apPaterno',
            width: 130, align: 'left'},
        {
            text: 'A. Materno', dataIndex: 'apMaterno',
            width: 130, align: 'left'},
        {
            text: 'Nombres', dataIndex: 'nombres',
            width: 160, align: 'left'},
        {
            text: 'Teléfono', dataIndex: 'telefono'},
        {
            text: 'Dirección', dataIndex: 'direccion',
            flex: 2, align: 'left'},
        {
            text: 'Tipo', dataIndex: 'tipoTrabajador.descripcion',
            xtype: 'templatecolumn', tpl: '{tipoTrabajador.descripcion}',
            align: 'center'},
        {
            text: 'Estado', dataIndex: 'estadoTrabajador.descripcion',
            xtype: 'templatecolumn', tpl: '{estadoTrabajador.descripcion}',
            align: 'center'
        }
    ],

    allowDeselect: true,
    bind: {
        selection: '{rowSelect}'
    },

    tbar: [{
            text: 'Nuevo',
            iconCls: 'fa fa-plus',
            bind: {
                disabled: '{rowSelect}'
            },
            listeners: {
                click: 'nuevoTrabajador'
            }
        }, {
            text: 'Editar',
            iconCls: 'fa fa-edit',
            disabled: true,
            bind: {
                disabled: '{!rowSelect}'
            },
            listeners: {
                click: 'editarTrabajador'
            }
        }, '-', {
            text: 'Ver',
            iconCls: 'fa fa-search',
            disabled: true,
            bind: {
                disabled: '{!rowSelect}'
            },
            listeners: {
                click: 'verTrabajador'
            }
        }],

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar",
            items: ['-', {
                    iconCls: 'fa fa-file-excel-o'
                }]
        }],

    listeners: {
        select: 'onItemSelected'
    }

});