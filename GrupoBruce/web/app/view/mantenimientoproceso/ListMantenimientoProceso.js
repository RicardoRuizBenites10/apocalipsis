Ext.define('GrupoBruce.view.mantenimientoproceso.ListMantenimientoProceso', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistMantenimientoProceso',
    reference: 'list_mantenimientoProceso',

    bind: {
        store: '{mantenimientosProceso}',
        selection: '{selectMantenimientoProceso}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Fecha'
        }, {
            text: 'Observación',
            flex: 1
        }, {
            text: 'Generador'
        }],
    tbar: {
        items: [{
                xtype: 'combobox',
                editable: false
            }, '-', {
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{!selectMantenimientoProceso}'
                },
                handler: 'addMantenimientoProceso'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{mantenimientosProceso}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});