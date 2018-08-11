Ext.define('GrupoBruce.view.trabajador.TrabajadorList', {
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',

    store: {
        type: 'Strabajador'
    },

    columns: [
        { text: 'Código',  dataIndex: 'idTrabajador' },
        { text: 'Nombres', dataIndex: 'montoPasaje', flex: 1 },
        { text: 'Carrera', dataIndex: 'montoBase', flex: 1 }
    ]

});