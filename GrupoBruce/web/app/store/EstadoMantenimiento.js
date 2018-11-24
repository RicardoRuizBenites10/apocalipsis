Ext.define('GrupoBruce.store.EstadoMantenimiento', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.EstadoMantenimiento',
    alias: 'store.SestadoMantenimiento',

    remoteSort: true,
    remoteFilter: true
});