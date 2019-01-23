Ext.define('GrupoBruce.view.almuerzo.ListAlmuerzo', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAlmuerzo',
    reference: 'list_almuerzo',
    id: 'id_wlistalmuerzo',

    requires: [
        'Ext.grid.RowNumberer'
    ],

    bind: {
        store: '{almuerzos}',
        selection: '{selectAlmuerzo}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'rownumberer'
        }, {
            text: 'Trabajador',
            dataIndex: 'trabajador',
            width: 400,
            align: 'left'
        }, {
            text: 'Fecha',
            dataIndex: 'fecha',
            formatter: 'date("d/m/Y")',
            align: 'center',
            width: 150
        }, {
            text: 'Refrigerio',
            dataIndex: 'refrigerio',
            align: 'center',
            renderer: function(val){
                return val ? 'SI' : 'NO';
            },
            width: 150
        }, {
            text: 'Almuerzo',
            dataIndex: 'enComedor',
            align: 'center',
            renderer: function(val){
                return val ? 'Consesionario' : 'Fuera';
            },
            width: 200
        },{
            text: 'Situacion',
            dataIndex: 'procesado',
            renderer: function(val){
                if(!val){
                    return '<span style="background:#566573;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> POR PROCESAR </span>';
                }else{
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> PROCESADO </span>';
                }
            },
            align: 'center'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'datefield',
                id: 'id_dateDesde',
                reference: 'date_desde',
                fieldLabel: 'Desde',
                format: 'd/m/Y',
                bind: '{desde}'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectAlmuerzo}'
                },
                handler: 'editAlmuerzo'
            }, '-', {
                iconCls: 'x-fa fa-retweet',
                text: 'Procesar',
                handler: 'onProcesar'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{almuerzos}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});