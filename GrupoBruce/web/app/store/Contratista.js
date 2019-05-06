Ext.define('GrupoBruce.store.Contratista',{
    extend: 'Ext.data.Store',
    alias: 'store.Scontratista',
    model: 'GrupoBruce.model.Contratista',
    
    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'NOMBRE',
            direction: 'ASC'
    }]
});