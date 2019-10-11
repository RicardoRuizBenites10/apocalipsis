Ext.define('GrupoBruce.store.EspecificacionCategoria',{
    extend: 'Ext.data.TreeStore',
    model: 'GrupoBruce.model.EspecificacionCategoria',
    alias: 'store.Sespecificacioncategoria',
    
    parentIdProperty: 'idSupecategoria',
    
    remoteSort: true,
    remoteFilter: true
});