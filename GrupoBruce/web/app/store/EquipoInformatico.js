Ext.define('GrupoBruce.store.EquipoInformatico', {
    extend: 'Ext.data.Store',
    alias: 'store.SequipoInformatico',
    model: 'GrupoBruce.model.EquipoInformatico',

    remoteSort: true,
    remoteFilter: true
});