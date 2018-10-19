Ext.define('GrupoBruce.store.TipoVacacion',{
    extend: 'Ext.data.Store',
    alias: 'store.StipoVacacion',
    model: 'GrupoBruce.model.TipoVacacion',
    
    remoteSort: true,
    remoteFilter: true
});