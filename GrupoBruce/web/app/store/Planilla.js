Ext.define('GrupoBruce.store.Planilla',{
    extend: 'Ext.data.Store',
    alias: 'store.Splanilla',
    model: 'GrupoBruce.model.Planilla',
    
    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: 'FECHA',
            direction: 'ASC'
        }]
    
});