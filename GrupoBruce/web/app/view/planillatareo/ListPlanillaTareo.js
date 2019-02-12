Ext.define('GrupoBruce.view.planillatareo.ListPlanillaTareo', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistPlanillaTareo',
    reference: 'list_planillaTareo',

    bind: {
        store: '{planillasTareo}',
        selection: '{selectPlanillaTareo}'
    },
    allowDeselect: true,

    requires: [
        'Ext.grid.RowNumberer'
    ],

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'rownumberer'
        }, {
            text: 'Trabajador',
            dataIndex: 'trabajador',
            align: 'center'
        }, {
            text: 'Entidad a manejar',
            dataIndex: 'entidad',
            align: 'left',
            width: 250
        }, {
            text: 'Estado',
            dataIndex: 'estado',
            width: 150,
            align: 'center',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            }
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'combo',
                emptyText: 'Seleccionar',
                displayField: 'descripcion',
                valueField: 'idTtrabajador',
                editable: false,
                bind: {
                    store: '{tiposTrabajador}',
                    selection: '{selectTipoTrabajador}'
                }
            }, {
                xtype: 'combo',
                emptyText: 'Seleccionar',
                displayField: 'denominacion',
                valueField: 'idPplanilla',
                editable: false,
                bind: {
                    store: '{periodosPlanilla}',
                    selection: '{selectPeriodoPlanilla}'
                }
            }, '-', {
                iconCls: 'x-fa fa-retweet',
                disabled: true,
                text: 'Etapas de proceso',
                bind: {
                    disabled: '{!selectPlanillaTareo}'
                },
                handler: 'onEtapasPlanillaTareo'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{planillasTareo}'
            },
            displayInfo: true
        }]
});