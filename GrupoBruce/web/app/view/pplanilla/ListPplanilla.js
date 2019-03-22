Ext.define('GrupoBruce.view.pplanilla.ListPplanilla', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistPplanilla',
    reference: 'list_pplanilla',
    id: 'id_wlistpplanilla',

    requires: [
        'Ext.grid.RowNumberer'
    ],
    plugins: [{
            ptype: 'rowediting',
            clicksToMoveEditor: 1,
            autoCancel: false
        }],

    bind: {
        store: '{planillasTareo}',
        selection: '{selectConceptoAsignado}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'rownumberer'
        }, {
            text: 'Trabajador',
            sortable: false,
            dataIndex: 'trabajador',
            width: 300,
            align: 'left'
        }, {
            text: 'Aprobado',
            dataIndex: 'aprobado',
            align: 'center',
            renderer: function (val) {
                if (!val) {
                    return '<span style="background:#566573;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> POR APROBAR </span>';
                } else {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> APROBADO </span>';
                }
            }
        }, {
            text: 'Procesado',
            dataIndex: 'procesado',
            align: 'center',
            renderer: function (val) {
                if (!val) {
                    return '<span style="background:#566573;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> POR PROCESAR </span>';
                } else {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> PROCESADO </span>';
                }
            }
        }, {
            text: 'Haber',
            sortable: false,
            dataIndex: 'haberBasico'
        }, {
            text: 'DATOS PARA INGRESO',
            columns: [{
                    text: 'Días',
                    columns: [{
                            text: 'Periodo',
                            sortable: false,
                            dataIndex: 'diasPeriodo'
                        }, {
                            text: 'Trabajados',
                            sortable: false,
                            dataIndex: 'diasTrabajado'
                        }]
                }, {
                    text: 'Horas',
                    columns: [{
                            text: 'Extra 50%',
                            sortable: false,
                            dataIndex: 'hextra25'
                        }, {
                            text: 'Extra 100%',
                            sortable: false,
                            dataIndex: 'hextra35'
                        }]
                }, {
                    text: 'Movilidad',
                    sortable: false,
                    dataIndex: 'movilidad'
                }, {
                    text: 'Reintegro',
                    sortable: false,
                    dataIndex: 'reintegro',
                    xtype: 'numbercolumn',
                    editor: {
                        xtype: 'numberfield',
                        allowBlank: false,
                        hideTrigger: true,
                        minValue: 0
                    }
                }, {
                    text: 'Asignación',
                    sortable: false,
                    dataIndex: 'flagAsig',
                    renderer: function (val) {
                        return val ? 'SI' : 'NO';
                    },
                    align: 'center'
                }]
        }, {
            text: 'DATOS PARA DESCUENTO',
            columns: [{
                    text: 'Horas',
                    columns: [{
                            text: 'Descuento',
                            sortable: false,
                            dataIndex: 'horasDesct'
                        }]
                }, {
                    text: 'Almuerzos',
                    sortable: false,
                    dataIndex: 'otrosDesct'
                }, {
                    text: 'Prestamo',
                    sortable: false,
                    dataIndex: 'prestamo'
                }, {
                    text: 'Adelanto',
                    sortable: false,
                    dataIndex: 'adelanto',
                    hidden: true,
                    bind: {
                        hidden: '{selectTipoTrabajador.jornalDiario}'
                    }
                }, {
                    text: 'Regimen',
                    sortable: false,
                    dataIndex: 'rpregimen',
                    renderer: function (val) {
                        return val === '' ? 'Ninguno' : (val === '02' ? 'ONP' : 'AFP');
                    },
                    align: 'center'
                }]
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'combobox',
                displayField: 'descripcion',
                valueField: 'idTtrabajador',
                bind: {
                    store: '{tipostrabajador}',
                    selection: '{selectTipoTrabajador}'
                },
                emptyText: 'Tipo trabajador',
                editable: false
            }, {
                xtype: 'combobox',
                id: 'id_idpp',
                displayField: 'denominacion',
                valueField: 'idPplanilla',
                bind: {
                    store: '{periodosPlanilla}',
                    selection: '{selectPeriodoPlanilla}'
                },
                emptyText: 'Elije periodo planilla',
                forceSelection: true,
                editable: false,
                width: 210
            }, {
                text: 'Aprobar datos',
                iconCls: 'x-fa fa-check-circle-o',
                disabled: true,
                bind: {
                    disabled: '{!allRecord}'
                },
                handler: 'onAprobar'
            }, {
                text: 'Procesar información',
                iconCls: 'x-fa fa-retweet',
                disabled: true,
                bind: {
                    disabled: '{!allRecord}'
                },
                handler: 'onProcesar'
            }, {
                text: 'Cuadro de remuneración',
                iconCls: 'x-fa fa-print',
                disabled: true,
                bind: {
                    disabled: '{!allRecord}'
                },
                handler: 'onPrintCuadro'
            }]
    }
});