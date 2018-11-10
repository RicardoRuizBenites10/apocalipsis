Ext.define('GrupoBruce.view.equipo.ListEquipo', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistEquipo',
    reference: 'list_equipo',

    bind: {
        store: '{equiposInformatico}',
        selection: '{selectEquipo}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Tipo',
            dataIndex: 'idTequipo',
            renderer: function (val) {
                switch (val) {
                    case '01':
                        return 'CPU';
                    case '02':
                        return 'Monitor';
                    case '03':
                        return 'Mouse';
                    case '04':
                        return 'Teclado';
                    case '05':
                        return 'Parlante';
                    case '06':
                        return 'Switch';
                    case '07':
                        return 'Impresora';
                }
            },
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'denominacion',
            align: 'left',
            flex: 2
        }, {
            text: 'Serie',
            dataIndex: 'serie',
            align: 'center'
        }, {
            text: 'Inicio de uso',
            dataIndex: 'fechaBase',
            formatter: 'date("d/m/Y")'
        }, {
            text: 'Tiempo de uso',
            dataIndex: 'fechaBase',
            renderer: function (val) {
                var hoy = new Date();
                var fecha = new Date(val);
                return Ext.Date.diff(fecha, hoy, Ext.Date.YEAR) + ' años';
            }
        }, {
            text: 'Estado',
            dataIndex: 'idEequipo',
            renderer: function (val) {
                switch (val) {
                    case 1:
                        return 'Por asignar';
                    case 2:
                        return 'Asignado';
                    case 3:
                        return 'En mantenimiento';
                    case 4:
                        return 'De baja';
                }
            },
            align: 'center'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectEquipo}'
                },
                handler: 'addEquipo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectEquipo}'
                },
                handler: 'editEquipo'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectEquipo}'
                },
                handler: 'deleteEquipo'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{equiposInformatico}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});
