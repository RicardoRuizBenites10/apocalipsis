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
            align: 'left',
            filter: true
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
            overflowHandler: 'menu',
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
                    text: 'Capacitación',
                    iconCls: 'x-fa fa-bookmark',
                    disabled: true,
                    bind: {
                        disabled: '{!selectTrabajador}'
                    },
                    handler: 'onEstudiosTrabajador'
                }, {
                    text: 'Ausencias',
                    iconCls: 'x-fa fa-calendar-o',
                    disabled: true,
                    bind: {
                        disabled: '{!selectTrabajador}'
                    },
                    handler: 'onAusenciasTrabajador'
                }, {
                    text: 'Contratos',
                    iconCls: 'x-fa fa-files-o',
                    disabled: true,
                    bind: {
                        disabled: '{!selectTrabajador}'
                    },
                    handler: 'onContratosTrabajador'
                }, {
                    text: 'Vacaciones',
                    iconCls: 'x-fa fa-gamepad',
                    disabled: true,
                    handler: 'onVacacionsTrabajador',
                    bind: {
                        disabled: '{!selectTrabajador}'
                    }
                }, {
                    text: 'Prestamos',
                    iconCls: 'x-fa fa-money',
                    disabled: true,
                    handler: 'onPrestamosTrabajador',
                    bind: {
                        disabled: '{!selectTrabajador}'
                    }
                }, {
                    text: 'Hijos',
                    iconCls: 'x-fa fa-child',
                    disabled: true,
                    bind: {
                        disabled: '{hasChild}'
                    },
                    handler: 'onHijosTrabajador'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            items: ['-', {
                    xtype: 'numberfield',
                    emptyText: 'Cantidad registros',
                    hideTrigger: true,
                    allowDecimal: false,
                    width: 130,
                    keyMap: {
                        ENTER: function (key, element) {
                            var grid = Ext.getCmp('id_ltrabajador');
                            var viewModel = grid.up('panel').getViewModel();
                            console.log('dada: ' + viewModel.get('pageSize'));
                            viewModel.set('pageSize', element.value);
                            console.log('dada 2: ' + viewModel.get('pageSize'));
                        }
                    }
                }, {
                    iconCls: 'fa fa-file-excel-o'
                }],
            overflowHandler: 'scroller'
        }]

});