Ext.define('GrupoBruce.store.EstadoEquipo', {
    extend: 'Ext.data.Store',
    alias: 'store.SestadoEquipo',
    model: 'GrupoBruce.model.EstadoEquipo',

    remoteSort: true,
    remoteFilter: true
});

