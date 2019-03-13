Ext.define('GrupoBruce.view.asistencia.ListAsistencia', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAsistencia',
    reference: 'list_asistencia',
    id: 'id_wlistasistencia',
    
    requires: [
        'Ext.grid.RowNumberer'
    ],
    plugins: [{
            ptype: 'rowediting',
            clicksToMoveEditor: 1,
            autoCancel: false
        }],
    
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
            text: 'Estado',
            dataIndex: 'ausencia',
            align: 'center',
            renderer: function (val) {
                switch (val) {
                    case 0:
                        return '<span style="background:#5bc0de;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> NINGUNO </span>';
                        break;
                    case 1:
                        return '<span style="background:#1479B8;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ASISTENCIA </span>';
                        break;
                    case 2:
                        return '<span style="background:#f0ad4e;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> PERMISO </span>';
                        break;
                    case 3:
                        return '<span style="background:#5D6D7E;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> VACACIÓN </span>';
                        break;
                    default:
                        return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> AUSENCIA </span>';
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
            text: 'Horas',
            columns: [{
                    text: 'No Trab.',
                    dataIndex: 'hrsDscto',
                    xtype: 'numbercolumn',
                    editor: {
                        xtype: 'numberfield',
                        allowBlank: false,
                        hideTrigger: true,
                        minValue: 0,
                        maxValue: 10
                    }
                }, {
                    text: 'Extras',
                    dataIndex: 'hrsExtra',
                    xtype: 'numbercolumn',
                    editor: {
                        xtype: 'numberfield',
                        allowBlank: false,
                        hideTrigger: true,
                        allowDecimal: true,
                        minValue: 0,
                        maxValue: 10
                    }
                }]
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
                bind: '{desde}',
                listeners: {
                    change: function (datefield, newValue, oldValue, eOpts) {
                        var viewModel = Ext.getCmp('id_wlistasistencia').up('panel').getViewModel();
                        viewModel.set('wasCalculated', false);
                    }
                }
            }, {
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo marca',
                disabled: true,
                bind: {
                    disabled: '{allowEdit}'
                },
                handler: 'addMarcacion'
            }, '-', {
                xtype: 'button',
                text: 'Calcular',
                iconCls: 'x-fa fa-calculator',
                disabled: true,
                bind: {
                    disabled: '{!allRecord}'
                },
                handler: 'onCalcular'
            }, {
                xtype: 'button',
                text: 'Procesar',
                iconCls: 'x-fa fa-retweet',
                disabled: true,
                bind: {
                    disabled: '{!allRecord}'
                },
                handler: 'onProcesar'
            }]
    }

});