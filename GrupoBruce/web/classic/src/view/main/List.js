Ext.define('GrupoBruce.view.main.List', {
    extend: 'Ext.grid.Panel',
    xtype: 'mainlist',

//    requires: [
//        'GrupoBruce.store.Personnel'
//    ],

    store: {
        type: 'Spersonnel'
    },

    columns: [
        { text: 'Código',  dataIndex: 'idTrabajador' },
        { text: 'Nombres', dataIndex: 'montoPasaje', flex: 1 },
        { text: 'Carrera', dataIndex: 'montoBase', flex: 1 }
    ],

    listeners: {
        select: 'onItemSelected'
    }
});
