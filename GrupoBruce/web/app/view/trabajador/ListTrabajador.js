Ext.define('GrupoBruce.view.trabajador.ListTrabajador', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistTrabajador',
    reference: 'list_trabajador',
    id: 'id_ltrabajador',

    plugins: [
        'gridfilters'
    ],

    bind: {
        store: '{trabajadors}',
        selection: '{selectTrabajador}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    title: 'Lista de trabajadores',
    closable: true,

    columns: [{
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
            text: 'Teléfono', dataIndex: 'telefono'
        }, {
            text: 'Dirección', dataIndex: 'direccion',
            flex: 2, align: 'left'
        }, {
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

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'scroller',
            items: [{
                    text: 'Nuevo',
                    iconCls: 'x-fa fa-plus',
                    bind: {
                        disabled: '{selectTrabajador}'
                    },
                    listeners: {
                        click: 'addTrabajador'
                    }
                }, {
                    text: 'Editar',
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    bind: {
                        disabled: '{!selectTrabajador}'
                    },
                    listeners: {
                        click: 'editTrabajador'
                    }
                }, {
                    text: 'Ver',
                    iconCls: 'x-fa fa-search',
                    disabled: true,
                    bind: {
                        disabled: '{!selectTrabajador}'
                    }
                }, '-', {
                    text: 'Estudios',
                    iconCls: 'x-fa fa-graduation-cap',
                    hidden: true,
                    bind: {
                        hidden: '{!selectTrabajador}'
                    },
                    handler: 'onEstudiosTrabajador'
                }, {
                    text: 'Contratos',
                    iconCls: 'x-fa fa-files-o',
                    hidden: true,
                    bind: {
                        hidden: '{!selectTrabajador}'
                    },
                    handler: 'onContratosTrabajador'
                }, {
                    text: 'Vacaciones',
                    iconCls: 'x-fa fa-gamepad',
                    hidden: true,
                    handler: 'onVacacionsTrabajador',
                    bind: {
                        hidden: '{!selectTrabajador}'
                    }
                }, {
                    text: 'Hijos',
                    iconCls: 'x-fa fa-child',
                    hidden: true,
                    bind: {
                        hidden: '{hasChild}'
                    },
                    handler: 'onHijosTrabajador'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar",
            items: ['-', {
                    iconCls: 'fa fa-file-excel-o'
                }],
            overflowHandler: 'scroller'
        }]

});