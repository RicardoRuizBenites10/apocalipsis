Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Model',
    alias: 'store.Strabajador',

    model: 'Mtrabajador',
    
    autoLoad: true,
    proxy: {
        type: 'ajax',
        api: {
            read: 'rrhh/trabajadores'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty : 'success'
        }
    }

});