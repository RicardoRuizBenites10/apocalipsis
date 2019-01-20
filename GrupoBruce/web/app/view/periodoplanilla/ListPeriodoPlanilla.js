Ext.define('GrupoBruce.view.periodoplanilla.ListPeriodoPlanilla', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistPeriodoPlanilla',
    reference: 'list_periodoPlanilla',
    id: 'id_wlistperiodoplanilla',
    
    requires: [
        'Ext.grid.RowNumberer'
    ],

    bind: {
        store: '{periodosPlanilla}',
        selection: '{selectPeriodoPlanilla}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'rownumberer'
        },{
            text: 'Denominación',
            name: 'denominacion',
            width: 200
        }, {
            text: 'Fecha inicio',
            dataIndex: 'inicio',
            align: 'center',
            formatter: 'date("d/m/Y")'
        }, {
            text: 'Fecha fin',
            dataIndex: 'fin',
            align: 'center',
            formatter: 'date("d/m/Y")'
        }, {
            text: 'Situación',
            dataIndex: 'cerrado',
            width: 150,
            align: 'center',
            renderer: function (val) {
                if (!val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> Abierto </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> Cerrado </span>';
                }
            }
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectPeriodoPlanilla}'
                },
                handler: 'addPeriodoPlanilla'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectPeriodoPlanilla}'
                },
                handler: 'editPeriodoPlanilla'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectPeriodoPlanilla}'
                },
                handler: 'deletePeriodoPlanilla'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{periodosPlanilla}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});