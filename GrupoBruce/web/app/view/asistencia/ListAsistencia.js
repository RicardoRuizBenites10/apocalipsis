Ext.define('GrupoBruce.view.asistencia.ListAsistencia', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAsistencia',
    reference: 'list_asistencia',

    requires: [
        'Ext.grid.RowNumberer'
    ],

    bind: {
        store: '{asistencias}',
        selection: '{selectAsistencia}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'rownumberer'
        }, {
            text: 'DNI',
            dataIndex: 'idTrabajador',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'trabajador',
            sortable: false,
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
                switch (val) {
                    case 0:
                        return '<span style="background:#566573;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> NINGUNO </span>';
                        break;
                    case 1:
                        return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ASISTENCIA </span>';
                        break;
                    case 2:
                        return '<span style="background:#9B59B6;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> PERMISO </span>';
                        break;
                    case 3:
                        return '<span style="background:#5D6D7E;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> VACACIÓN </span>';
                        break;
                    default:
                        return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> FALTA </span>';
                }
            }
        }, {
            text: 'Marcas',
            columns: [{
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
                }]
        }, {
            text: 'Ausencia',
            xtype: 'templatecolumn',
            tpl: '{marca1}',
            align: 'left'
        }, {
            text: 'H.Extra',
            dataIndex: 'hextra',
            renderer: function (val, metadata, record) {
                var hh = 0;
                console.log(record.get('marca1'));
                if (record.marca1 !== undefined) {
                    console.log("marca1: " + record.marca1);
                }
                return 0;
            },
            align: 'left'
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
                    disabled: '{!selectAsistencia}' && '{!selectAsistencia.ausencia}'
                },
                handler: 'addMarcacion'
            }, {
                xtype: 'button',
                text: 'Procesar',
                iconCls: 'x-fa fa-retweet',
                handler: 'onProcesar'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{asistencias}'
            },
            displayInfo: true
        }]

});