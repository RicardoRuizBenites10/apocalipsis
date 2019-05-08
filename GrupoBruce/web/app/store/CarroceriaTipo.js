Ext.define('GrupoBruce.store.CarroceriaTipo',{
    extend: 'Ext.data.Store',
    alias: 'store.Scarroceriatipo',
    model: 'GrupoBruce.model.CarroceriaTipo',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'NOMBRE',
            direction: 'ASC'
        }]
});