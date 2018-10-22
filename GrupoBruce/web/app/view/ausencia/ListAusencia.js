Ext.define('GrupoBruce.view.ausencia.ListAusencia', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAusencia',
    reference: 'list_ausencia',

    bind:{
        store: '{ausencias}',
        selection: '{selectAusencia}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Fecha inicio',
            dataIndex: 'fechaInicio'
        },{
            text: 'Fecha fin',
            dataIndex: 'fechaFin'
        }, {
            text: 'Tipo ausencia',
            dataIndex: 'idTausencia'
        }, {
            text: 'Tiempo ausencia',
            dataIndex: 'idTmausencia'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectAusencia}'
                },
                handler: 'addAusencia'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectAusencia}'
                },
                handler: 'editAusencia'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectAusencia}'
                },
                handler: 'deleteAusencia'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{ausencias}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});