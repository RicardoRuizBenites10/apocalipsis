Ext.define('GrupoBruce.view.asistencia.ListAsistencia', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAsistencia',
    reference: 'list_asistencia',

    bind: {
        store: '{asistencias}',
        selection: '{selectAsistencia}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'DNI',
            dataIndex: 'idTrabajador',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'trabajador',
            width: 300,
            align: 'left'
        }, {
            text: 'Fecha',
            dataIndex: 'fecha',
            formatter: 'date("d/m/Y")',
            align: 'left'
        }, {
            text: 'Situación',
            dataIndex: 'ausencia',
            width: 150,
            align: 'center',
            renderer: function (val) {
                switch(val){
                    case 0: return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ASISTENCIA </span>';
                        break;
                    case 1: return '<span style="background:#9B59B6;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> PERMISO </span>';
                        break;
                    case 2: return '<span style="background:#5D6D7E;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> VACACION </span>';
                }
            }
        }, {
            text: 'Primera',
            dataIndex: 'marca1',
            formatter: 'date("h:i A")',
            align: 'center'
        }, {
            text: 'Última',
            dataIndex: 'marca7',
            formatter: 'date("h:i A")',
            align: 'center'
        }, {
            text: 'Marca 2',
            dataIndex: 'marca2',
            formatter: 'date("h:i A")',
            bind: {
                hidden: '{!checkAllMarcas.checked}'
            },
            align: 'center'
        }, {
            text: 'Marca 3',
            dataIndex: 'marca3',
            formatter: 'date("h:i A")',
            bind: {
                hidden: '{!checkAllMarcas.checked}'
            },
            align: 'center'
        }, {
            text: 'Marca 4',
            dataIndex: 'marca4',
            formatter: 'date("h:i A")',
            bind: {
                hidden: '{!checkAllMarcas.checked}'
            },
            align: 'center'
        }, {
            text: 'Marca 5',
            dataIndex: 'marca5',
            formatter: 'date("h:i A")',
            bind: {
                hidden: '{!checkAllMarcas.checked}'
            },
            align: 'center'
        }, {
            text: 'Marca 6',
            dataIndex: 'marca6',
            formatter: 'date("h:i A")',
            bind: {
                hidden: '{!checkAllMarcas.checked}'
            },
            align: 'center'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'checkbox',
                reference: 'checkAllMarcas',
                boxLabel: 'Todas las marcas'
            }, '-', {
                xtype: 'datefield',
                id: 'id_dateDesde',
                reference: 'date_desde',
                fieldLabel: 'Desde',
                format: 'd/m/Y',
                bind: '{desde}'
            }, '-', {
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo marca',
                disabled: true,
                bind: {
                    disabled: '{!selectAsistencia}'
                },
                handler: 'addMarcacion'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{asistencias}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});