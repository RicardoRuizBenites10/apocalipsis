Ext.define('GrupoBruce.store.PrestamoPago',{
    extend: 'Ext.data.Store',
    alias: 'store.SprestamoPago',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'fecha',
            direction: 'desc'
        }]
});