Ext.define('GrupoBruce.view.requerimiento.ListObraRequerimiento', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistobrarequerimiento',
    reference: 'list_obrarequerimiento',

    bind: {
        store: '{obras}',
        selection: '{selectObra}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Orden de producción',
            columns: [{
                    text: 'Nombre',
                    dataIndex: 'nombre'
                }, {
                    text: 'Modelo',
                    dataIndex: 'carroceria'
                }]
        }, {
            text: 'Programación',
            columns: [{
                    text: 'Inicio',
                    dataIndex: 'fechaIngreso',
                    formatter: 'date("d/m/Y")'
                }, {
                    text: 'Fin',
                    dataIndex: 'fechaSalida',
                    formatter: 'date("d/m/Y")'
                }]
        }, {
            text: 'Área',
            columns: [{
                    text: 'Nombre',
                    dataIndex: 'etapa'
                }, {
                    text: 'Inicio',
                    dataIndex: 'iniarea',
                    formatter: 'date("d/m/Y")'
                }, {
                    text: 'Fin',
                    dataIndex: 'finarea',
                    formatter: 'date("d/m/Y")'
                }]
        }, {
            text: 'Situación',
            dataIndex: 'estado'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'textfield'
                }, '-', {
                    text: 'Asignar ejecución',
                    iconCls: 'x-fa fa-file',
                    bind: {
                        disabled: '{!selectObra}'
                    },
                    handler: 'onRequerimiento'
                }, {
                    text: 'Asignar trabajo',
                    iconCls: 'x-fa fa-file',
                    bind: {
                        disabled: '{!selectObra}'
                    }
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{obras}'
            },
            displayInfo: true
        }]
});