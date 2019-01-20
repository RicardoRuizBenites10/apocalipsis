Ext.define('GrupoBruce.store.PrestamoPago',{
    extend: 'Ext.data.Store',
    alias: 'store.SprestamoPago',
    model: 'GrupoBruce.model.PrestamoPago',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'fecha',
            direction: 'desc'
        }]
});