Ext.define('GrupoBruce.view.mantenimientoeinformatico.ListMantenimientoEinformatico', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WmantenimientoEinformatico',
    reference: 'list_mantenimientoEinformatico',

    bind: {
        store: '{mantenimientosEinformatico}',
        selection: '{selectMantenimientoEinformatico}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'F.Programada'
        }, {
            text: 'F.Atendido'
        }],
    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectMantenimientoEinformatico}'
                },
                handler: 'addMantenimientoEinformatico'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectMantenimientoEinformatico}'
                },
                handler: 'deleteMantenimientoEinformatico'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{mantenimientosEinformatico}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});