Ext.define('GrupoBruce.store.Prestamo', {
    extend: 'Ext.data.Store',
    alias: 'store.Sprestamo',
    model: 'GrupoBruce.model.Prestamo',

    remoteSort: true,
    remoteFilter: true

});