Ext.define('GrupoBruce.store.ColorDiseno',{
    extend: 'Ext.data.Store',
    alias: 'store.Scolordiseno',
    model: 'GrupoBruce.model.ColorDiseno',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'denominacion',
            direction: 'ASC'
    }]
});