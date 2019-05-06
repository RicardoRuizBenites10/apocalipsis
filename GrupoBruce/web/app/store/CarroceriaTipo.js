Ext.define('GrupoBruce.store.CarroceriaTipo',{
    extend: 'Ext.data.Store',
    alias: 'store.ScarroceriaTipo',
    model: 'GrupoBruce.model.CarroceriaTipo',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'CODIGO',
            direction: 'ASC'
        }]
});