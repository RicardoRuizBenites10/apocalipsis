Ext.define('GrupoBruce.store.ContratoTrabajador', {
    extend: 'Ext.data.Store',
    alias: 'store.ScontratoTrabajador',
    model: 'GrupoBruce.model.ContratoTrabajador',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'ID_CONTRATO',
            direction: 'DESC'
        }]
});
