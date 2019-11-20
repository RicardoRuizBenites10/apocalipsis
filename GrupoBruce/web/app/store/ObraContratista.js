Ext.define('GrupoBruce.store.ObraContratista',{
    extend: 'Ext.data.Store',
    alias: 'store.Sobracontratista',
    model: 'GrupoBruce.model.ObraContratista',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-CONTRATISTA',
            direction: 'ASC'
        }]
});