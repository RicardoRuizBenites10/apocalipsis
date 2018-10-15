Ext.define('GrupoBruce.view.vacacion.ListVacacionTrabajador', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistVacacionTrabajador',
    reference: 'list_vacacionTrabajador',
    
    bind: {
        store: '{vacacions}',
        selection: '{selectVacacion}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Periodo'
        }, {
            text: 'Usado'
        }, {
            text: 'Vendido'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectVacacion}'
                },
                handler: 'addHijo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectVacacion}'
                },
                handler: 'editHijo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectVacacion}'
                },
                handler: 'deleteHijo'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{vacacions}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});