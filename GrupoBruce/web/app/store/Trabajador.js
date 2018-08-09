Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',
    alias: 'store.Strabajador',
    
    requires: [
        'Ext.data.proxy.Ajax'
    ],
    
    model: 'GrupoBruce.model.Aamon',

    autoLoad: true,
    proxy: {
        type: 'ajax',
        api: {
            read: 'trabajadores'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }

});