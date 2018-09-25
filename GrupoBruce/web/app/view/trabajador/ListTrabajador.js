Ext.define('GrupoBruce.view.trabajador.ListTrabajador', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.wlistTrabajador',
    reference: 'list_trabajador',

    plugins: [
        'gridfilters'
    ],

    bind: {
        store: '{trabajadors}',
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
        },
        {
            text: 'Tipo', dataIndex: 'idTtrabajador', sortable: false,
            renderer: function (val) {
                switch (val) {
                    case 19:
                        return 'Ejecutivo';
                    case 20:
                        return 'Obrero';
                    case 22:
                        return 'Empleado';
                    case 23:
                        return 'Practicante';
                }
            },
            align: 'left'
        },
        {
            text: 'Estado', dataIndex: 'idEtrabajador', sortable: false,
            renderer: function (val) {
                switch (val) {
                    case 0:
                        return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                    case 1:
                        return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                    case 2:
                        return 'Sin vinculo laboral';
                }
            },
            align: 'left'
        }
    ],

    tbar: [{
            text: 'Nuevo',
            iconCls: 'fa fa-plus',
            bind: {
                disabled: '{rowSelect}'
            }, 
            listeners: {
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
        }, {
            text: 'Ver',
            iconCls: 'fa fa-search',
            disabled: true,
            bind: {
                disabled: '{!rowSelect}'
            }
        }, '-', {
            text: 'Contratos',
            iconCls: 'fa fa-files-o',
            disabled: true,
            bind: {
                disabled: '{!rowSelect}'
            }
        }, {
            text: 'Vacaciones',
            iconCls: 'fa fa-gamepad',
            disabled: true,
            bind: {
                disabled: '{!rowSelect}'
            }
        }, {
            text: 'Hijos',
            iconCls: 'fa fa-child',
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