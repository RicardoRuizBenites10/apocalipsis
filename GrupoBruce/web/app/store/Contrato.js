Ext.define('GrupoBruce.store.Contrato',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.ContratoTrabajador',
    alias: 'store.Scontrato',
    
    pageSize: 15,
    remoteSort: true,
    remoteFilter: true
    
});
