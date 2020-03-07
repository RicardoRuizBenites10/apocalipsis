Ext.define('GrupoBruce.store.RequerimientoMaterial',{
    extend: 'Ext.data.Store',
    alias: 'store.Srequerimientomaterial',
    model: 'GrupoBruce.model.RequerimientoMaterial',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-MATERIAL',
            direction: 'ASC'
        }]
});