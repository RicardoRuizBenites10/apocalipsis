Ext.define('Grupobruce.store.Vacacion',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Vacacion',
    alias: 'store.Svacacion',
    
    remoteFilter: true,
    remoteSort: true,
    
    sorters: [{
            property: 'ID_VACACION',
            direction: 'ASC'
        }]
    
});