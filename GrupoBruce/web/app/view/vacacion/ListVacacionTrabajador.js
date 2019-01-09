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
            text: 'Periodo',
            dataIndex: 'idPVacacion',
            align: 'center'
        },{
            text: 'Tipo',
            dataIndex: 'tipo',
            align: 'left'
        },{
            text: 'Fecha base',
            formatter: 'date("d/m/Y")',
            dataIndex: 'fechaBase'
        },{
            text: 'Fecha inicio',
            formatter: 'date("d/m/Y")',
            dataIndex: 'fechaSalida'
        },{
            text: 'Fecha retorno',
            formatter: 'date("d/m/Y")',
            dataIndex: 'fechaRetorno'
        }, {
            text: 'Nro días',
            dataIndex: 'diasTomados',
            align: 'center'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectVacacion}'
                },
                handler: 'addVacacion'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectVacacion}'
                },
                handler: 'editVacacion'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectVacacion}'
                },
                handler: 'deleteVacacion'
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