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
            text: 'Programado',
            dataIndex: 'fechaProgramada',
            formatter: 'date("d/m/Y")'
        }, {
            text: 'Detalle',
            dataIndex: 'observacion',
            align: 'left',
            flex: 1
        },{
            text: 'Estado',
            dataIndex: 'idEmantenimiento',
            align: 'left',
            renderer: function(val){
                switch(val){
                    case '01':
                        return 'Requerido';
                    case '02':
                        return 'Asignado';
                    case '03':
                        return 'En preceso';
                    case '04':
                        return 'Terminado';
                    case '05':
                        return 'En entrega';
                    case '06':
                        return 'Recepcionado';
                }
            }
        },{
            text: 'Atendido',
            dataIndex: 'fechaAtendido',
            formatter: 'date("d/m/Y")'
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
            }, {
                iconCls: 'x-fa fa-eye',
                disabled: true,
                text: 'Seguimiento',
                bind: {
                    disabled: '{!selectMantenimientoEinformatico}'
                },
                handler: 'seguimientoMantenimientoEinformatico'
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