Ext.define('GrupoBruce.view.main.List', {
    extend: 'Ext.grid.Panel',
    xtype: 'mainlist',

//    requires: [
//        'GrupoBruce.store.Personnel'
//    ],

    store: {
        type: 'personnel'
    },
    
    title: 'Personnel',
    
    columns: [
        { text: 'Name',  dataIndex: 'name' },
        { text: 'Email', dataIndex: 'email', flex: 1 },
        { text: 'Phone', dataIndex: 'phone', flex: 1 }
    ],

    listeners: {
        select: 'onItemSelected'
    }
});
