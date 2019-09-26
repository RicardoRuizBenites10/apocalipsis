Ext.define('GrupoBruce.store.EtapaProceso', {
    extend: 'Ext.data.TreeStore',
    model: 'GrupoBruce.model.EtapaProceso',
    alias: 'store.Setapaproceso',
    
    parentIdProperty: 'idSupeproceso',

    remoteSort: true,
    remoteFilter: true
});