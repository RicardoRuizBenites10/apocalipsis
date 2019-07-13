Ext.define('GrupoBruce.store.EtapaProceso', {
    extend: 'Ext.data.Store',
    alias: 'store.Setapaproceso',
    model: 'GrupoBruce.model.EtapaProceso',

    remoteSort: true,
    remoteFilter: true
});