Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',
    
    alias: 'store.strabajador',

    model: 'GrupoBruce.model.Aamon',
    proxy: {
        type: 'ajax',
        api: {
            read: 'trabajadores'
        },
        paramsAsJson: true,
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    },
    autoLoad: true

});