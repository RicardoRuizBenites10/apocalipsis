Ext.define('GrupoBruce.view.asistencia.ListAsistencia', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAsistencia',
    reference: 'list_asistencia',
    id: 'id_wlistasistencia',

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
            dataIndex: 'procesado',
            renderer: function (val) {
                if (!val) {
                    return '<span style="background:#566573;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> POR PROCESAR </span>';
                } else {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> PROCESADO </span>';
                }
            },
            align: 'center'
        }, {
            text: 'Estado',
            dataIndex: 'ausencia',
            align: 'center',
            renderer: function (val) {
                switch (val) {
                    case 0:
                        return '<span style="background:#3498DB;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> NINGUNO </span>';
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
        },{
            text: 'Horas',
            columns: [{
            text: 'No Trab.',
            dataIndex: 'horasTrabajado',
            renderer: function (val, metadata, record, rowIndex, colIndex, store, view) {
                var marca1 = record.get('marca1'), marca7 = record.get('marca7');
                var dada = view.up('panel').up('panel').getViewModel().get('diaHorario');
                var horas = marca1 !== null && marca7 !== null ? ((Ext.Date.diff(marca1, marca7, Ext.Date.MINUTE) === 0 ? 540 : Ext.Date.diff(marca1, marca7, Ext.Date.MINUTE)) / 60) - 1 : 0;
                Ext.util.Format.decimalSeparator = '.';
                return Ext.util.Format.number(horas, '#.0');
            }
        }, {
            text: 'Extras',
            dataIndex: 'horasAusencia',
            renderer: function (val, metadata, record) {
                var marca1 = record.get('marca1'), marca7 = record.get('marca7');
                var horas = marca1 !== null && marca7 !== null ? Ext.Date.getDa: 100;
                return horas;
            }
                }]
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
            displayInfo: true,
            items: ['-', {
                    xtype: 'numberfield',
                    emptyText: 'Cantidad registros',
                    hideTrigger: true,
                    allowDecimal: false,
                    width: 130,
                    keyMap: {
                        ENTER: function (key, element) {
                            Ext.getCmp('id_wlistasistencia').up('panel').getViewModel().set('pageSize', element.value);
                        }
                    }
                }]
        }]

});