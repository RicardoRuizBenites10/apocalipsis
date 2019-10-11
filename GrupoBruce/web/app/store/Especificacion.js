Ext.define('GrupoBruce.store.Especificacion',{
    extend: 'Ext.data.Store',
    alias: 'store.Sespecificacion',
    model: 'GrupoBruce.model.Especificacion',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-CATEGORIA',
            direction: 'ASC'
        },{
            property: 'DESCRIPCION',
            direction: 'ASC'
        }]
});