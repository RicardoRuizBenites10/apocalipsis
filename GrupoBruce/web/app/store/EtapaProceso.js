Ext.define('GrupoBruce.store.EtapaProceso', {
    extend: 'Ext.data.Store',
    alias: 'store.SetapaProceso',
    model: 'GrupoBruce.model.EtapaProceso',

    remoteSort: true,
    remoteFilter: true
});