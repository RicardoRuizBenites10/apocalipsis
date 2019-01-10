Ext.define('GrupoBruce.store.TipoTrabajador',{
    extend: 'Ext.data.Store',
    alias: 'store.StipoTrabajador',
    model: 'GrupoBruce.model.TipoTrabajador',
    
    remoteSort: true,
    remoteFilter: true
});

