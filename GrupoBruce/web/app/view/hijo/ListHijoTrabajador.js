Ext.define('GrupoBruce.view.hijo.ListHijoTrabajador', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WhijoTrabajador',
    reference: 'list_hijoTrabajador',

    bind: {
        store: '{hijos}',
        selection: '{selectHijo}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'DNI',
            dataIndex: 'dni',
            sortable: true,
            flex: 1
        }, {
            text: 'Nacimiento',
            dataIndex: 'nacimiento',
            sortable: true,
            formatter: 'date("d/m/Y")',
            align: 'left'
        }, {
            text: 'Nombres',
            dataIndex: 'nombres',
            sortable: true,
            flex: 3,
            align: 'left'
        }, {
            text: 'Edad',
            dataIndex: 'nacimiento',
            sortable: true,
            flex: 1,
            renderer: function (val) {
                var hoy = new Date();
                var nacimiento = new Date(val);
                return Ext.Date.diff(nacimiento, hoy, Ext.Date.YEAR) + ' años';
            }
        }, {
            text: 'Género',
            dataIndex: 'idGenero',
            sortable: true,
            flex: 1,
            renderer: function (val) {
                switch (val) {
                    case 1:
                        return 'Masculino';
                    case 2:
                        return 'Femenino';
                }
            }
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectHijo}'
                },
                handler: 'addHijo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectHijo}'
                },
                handler: 'editHijo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectHijo}'
                },
                handler: 'deleteHijo'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{hijos}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});