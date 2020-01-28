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
            text: 'O.P.',
            dataIndex: 'nombre'
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
                    text: 'Nombre'
                }, {
                    text: 'Inicio'
                }, {
                    text: 'Fin'
                }]
        }, {
            text: 'Situación'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'textfield'
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