Ext.define('GrupoBruce.view.trabajador.ListTrabajador', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.wlistTrabajador',
    reference: 'list_trabajador',
    
    plugins: [
        'gridfilters'
    ],
   
    bind: {
        store: '{trabajadores}',
        selection: '{rowSelect}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',

    columns: [
        {
            text: 'DNI', dataIndex: 'idTrabajador',
            align: 'left'
//            ,filter: {type: 'string', value: ''}
        },
//        {
//            text: 'A. Paterno', dataIndex: 'persona.apPaterno',
//            xtype: 'templatecolumn', tpl: '{persona.apPaterno}',
//            width: 130, align: 'left'},
        {
            text: 'A. Paterno', dataIndex: 'apPaterno',
            width: 130, align: 'left'
        }, {
            text: 'A. Materno', dataIndex: 'apMaterno',
            width: 130, align: 'left'
        }, {
            text: 'Nombres', dataIndex: 'nombres',
            width: 160, align: 'left'
        }, {
            text: 'Teléfono', dataIndex: 'telefono'},
        {
            text: 'Dirección', dataIndex: 'direccion',
            flex: 2, align: 'left'
        }
    ],

    tbar: [{
            text: 'Nuevo',
            iconCls: 'fa fa-plus',
            bind: {
                disabled: '{rowSelect}'
            }
//            ,action: 'add'
            ,listeners: {
                click: 'addTrabajador'
            }
        }, {
            text: 'Editar',
            iconCls: 'fa fa-edit',
            disabled: true,
            bind: {
                disabled: '{!rowSelect}'
            },
            listeners: {
                click: 'editTrabajador'
            }
        }, '-', {
            text: 'Ver',
            iconCls: 'fa fa-search',
            disabled: true,
            bind: {
                disabled: '{!rowSelect}'
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
        }]

});