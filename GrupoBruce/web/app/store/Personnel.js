Ext.define('GrupoBruce.store.Personnel', {
    extend: 'Ext.data.Store',

    alias: 'store.Spersonnel',

    model: 'GrupoBruce.model.Trabajador',
    
    autoLoad: true,
    
    proxy: {
        type: 'ajax',
        url: 'trabajadores',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});