Ext.define('GrupoBruce.store.Trabajador',{
    extend: 'Ext.data.Model',
    alias: 'store.Strabajador',
    
    model: 'Mtrabajador',

    proxy: {
        type: 'ajax',
        method: 'POST',
        url: 'trabajadores',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    },
    autoLoad: true,
    
    sorters: [
        {property: 'persona.dni' , direction: 'ASC'}
    ]
    
});