Ext.define('GrupoBruce.store.AsignacionDetalle', {
    extend: 'Ext.data.Store',
    alias: 'store.SasignacionDetalle',
    model: 'GrupoBruce.model.AsignacionDetalle',

    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'ID_ADETALLE',
            direction: 'DESC'
        }]
});