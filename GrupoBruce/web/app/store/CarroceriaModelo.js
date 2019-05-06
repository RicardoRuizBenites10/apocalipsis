Ext.define('GrupoBruce.store.CarroceriaModelo',{
    extend: 'Ext.data.Store',
    alias: 'store.ScarroceriaModelo',
    model: 'GrupoBruce.model.CarroceriaModelo',
    
    remoteSort: true,
    remoteFilter: true
});