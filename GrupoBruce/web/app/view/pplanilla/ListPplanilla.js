Ext.define('GrupoBruce.view.pplanilla.ListPplanilla',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistPplanilla',
    reference: 'list_pplanilla',
    id: 'id_wlistpplanilla',

    bind: {
        store: '{conceptosAsignado}',
        selection: '{selectConceptoAsignado}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idConcepto',
            width: 200,
            align: 'center'
        }, {
            text: 'Descripción',
            dataIndex: 'descripcion',
            width: 200,
            align: 'left'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'combobox',
                displayField: 'descripcion',
                valueField: 'idTipo',
                bind: {
                    store: '{tiposPlanilla}',
                    selection: '{selectTipoPlanilla}'
                },
                emptyText: 'Seleccionar tipo planilla',
                editable: false,
                flex: 1
            }, {
                iconCls: 'x-fa fa-chevron-right',
                iconAlign: 'right',
                text: 'QUITAR',
                disabled: true,
                bind: {
                    disabled: '{!selectConceptoAsignado}'
                },
                handler: 'onDesasignar'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{conceptosAsignado}'
            },
            displayInfo: true
        }]
});