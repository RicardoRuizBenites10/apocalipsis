Ext.define('GrupoBruce.store.Textralaboral',{
    extend: 'Ext.data.Store',
    alias: 'store.Stextralaboral',
    model: 'GrupoBruce.model.Textralaboral',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-TRABAJADOR',
            direction: 'ASC'
    }]
});