Ext.define('GrupoBruce.store.Proveedor',{
    extend: 'Ext.data.Store',
    alias: 'store.Sproveedor',
    model: 'GrupoBruce.model.Proveedor',
    
    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'nombre',
            direction: 'ASC'
    }]
});