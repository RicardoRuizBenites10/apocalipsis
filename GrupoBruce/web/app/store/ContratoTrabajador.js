Ext.define('GrupoBruce.store.ContratoTrabajador', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.ContratoTrabajador',
    alias: 'store.ScontratoTrabajador',
    
    pageSize: 15,
    remoteSort: true,
    remoteFilter: true
});
