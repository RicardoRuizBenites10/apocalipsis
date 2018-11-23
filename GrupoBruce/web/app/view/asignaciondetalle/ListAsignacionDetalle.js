Ext.define('GrupoBruce.view.asignaciondetalle.ListAsignacionDetalle', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WasignacionDetalle',
    reference: 'list_asignacionDetalle',

    bind: {
        store: '{asignacionsDetalle}',
        selection: '{selectAsignacionDetalle}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Serie',
            dataIndex: 'idEinformatico',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'einformatico',
            width: 300,
            align: 'left'
        }, {
            text: 'Fecha',
            dataIndex: 'fechaAsignado',
            formatter: 'date("d/m/Y")',
            align: 'center'
        }, {
            text: 'Estado',
            dataIndex: 'asignado',
            renderer: function (val) {
                return val ? 'Asignado' : 'Desasignado';
            },
            align: 'center'
        }],
    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectAsignacionDetalle}'
                },
                handler: 'addAsignacionDetalle'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectAsignacionDetalle}'
                },
                handler: 'deleteAsignacionDetalle'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{asignacionsDetalle}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});