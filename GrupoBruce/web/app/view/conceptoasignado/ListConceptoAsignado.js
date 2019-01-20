Ext.define('GrupoBruce.view.conceptoasignado.ListConceptoAsignado', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistConceptoAsignado',
    reference: 'list_conceptoAsignado',
    id: 'id_wlistconceptoasignado',

    bind: {
        store: '{conceptosAsignado}',
        selection: '{selectConceptoAsignado}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idCasignado',
            align: 'center'
        }, {
            text: 'Fecha',
            dataIndex: 'fecha',
            align: 'center',
            formatter: 'date("d/m/Y")'
        }, {
            text: 'Nombre',
            width: 250,
            align: 'left'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectConceptoAsignado}'
                },
                handler: 'addConceptoAsignado'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectConceptoAsignado}'
                },
                handler: 'deleteConceptoAsignado'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{conceptosAsignado}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});