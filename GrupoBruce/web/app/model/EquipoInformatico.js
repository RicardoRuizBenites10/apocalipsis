Ext.define('GrupoBruce.model.EquipoInformatico', {
    extend: 'Ext.data.Model',
    alias: 'model.MequipoInformatico',
    
    idProperty: 'idEinformatico',
    fields: [
        { name: 'denominacion', type: 'string' },
        { name: 'fechaCreate', type: 'date' },
        { name: 'fechaUpdate', type: 'date' },
        { name: 'idEequipo', type: 'int' },
        { name: 'idEinformatico', type: 'string' },
        { name: 'idTequipo', type: 'string' },
        { name: 'serie', type: 'string' }
    ],
    
    identifier: {
        type: 'sequential'
    },
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEquipoInformatico',
            read: 'equiposInformatico',
            update: 'uuEquipoInformatico',
            destroy: 'ddEquipoInformatico'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
