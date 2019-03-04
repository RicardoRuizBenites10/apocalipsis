Ext.define('GrupoBruce.view.pplanilla.ListPplanilla', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistPplanilla',
    reference: 'list_pplanilla',
    id: 'id_wlistpplanilla',

    requires: [
        'Ext.grid.RowNumberer'
    ],

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
            dataIndex: 'trabajador',
            width: 300,
            align: 'left'
        }, {
            text: 'Haber',
            dataIndex: 'haberBasico'
        }, {
            text: 'D.Periodo',
            dataIndex: 'diasPeriodo'
        }, {
            text: 'D.Trabajado',
            dataIndex: 'diasTrabajado'
        }, {
            text: 'H.Desct',
            dataIndex: 'horasDesct'
        }, {
            text: 'Almuerzos',
            dataIndex: 'otrosDesct'
        }, {
            text: 'Prestamo',
            dataIndex: 'prestamo'
        }, {
            text: 'Adelanto',
            dataIndex: 'adelanto'
        }, {
            text: 'H.E.25',
            dataIndex: 'hextra25'
        }, {
            text: 'H.E.35',
            dataIndex: 'hextra35'
        }, {
            text: 'Movilidad',
            dataIndex: 'movilidad'
        }, {
            text: 'Reintegro',
            dataIndex: 'reintegro'
        }, {
            text: 'Devolución',
            dataIndex: 'devolucion'
        }, {
            text: 'Asignación',
            dataIndex: 'flagAsig',
            renderer: function (val) {
                return val ? 'SI' : 'NO';
            },
            align: 'center'
        }, {
            text: 'AFP',
            dataIndex: 'flagAfp',
            renderer: function (val) {
                return val ? 'AFP' : 'ONP';
            },
            align: 'center'
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
            },{
                text: 'Aprobar',
                iconCls: 'x-fa fa-check-circle-o',
                disabled: true,
                bind: {
                    disabled: '{!allRecord}'
                }
            },{
                text: 'Procesar',
                iconCls: 'x-fa fa-retweet',
                disabled: true,
                bind: {
                    disabled: '{!allRecord}'
                }
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{planillasTareo}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando {0} - {2} de {2}',
            items: ['-', {
                    xtype: 'numberfield',
                    emptyText: 'Cantidad registros',
                    hideTrigger: true,
                    allowDecimal: false,
                    width: 130,
                    keyMap: {
                        ENTER: function (key, element) {
                            var grid = Ext.getCmp('id_wlistpplanilla');
                            var viewModel = grid.up('panel').getViewModel();
                            var store = grid.getStore();
                            viewModel.set('pageSize', element.value);
                        }
                    }
                }]
        }]
});