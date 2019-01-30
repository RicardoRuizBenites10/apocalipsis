Ext.define('GrupoBruce.store.EstadoMantenimiento', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.EstadoMantenimiento',
    alias: 'store.SEstadoMantenimiento',

    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'ID_ESTADO',
            direction: 'ASC'
        }]
});