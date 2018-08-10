Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',

    store: {
        xtype: 'Strabajador'
    },

    columns: [{
            text: 'CODIGO',
            dataIndex: 'codigo',
            flex: 1
        },{
            text: 'NOMBRES',
            dataIndex: 'nombres',
            flex: 1
        },{
            text: 'CARRERA',
            dataIndex: 'carrerra',
            flex: 1
        }
    ]

});


