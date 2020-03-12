Ext.define('GrupoBruce.model.RequerimientoActividad', {
    extend: 'Ext.data.Model',
    alias: 'model.Mrequerimientoactividad',
    
    idProperty: 'idTemp',
    fields: [
        {name: 'actividad', type: 'string'},
        {name: 'despachado', type: 'float'},
        {name: 'estado', type: 'string'},
        {name: 'idActividad', type: 'int'},
        {name: 'idEspecificacion', type: 'int'},
        {name: 'idObra', type: 'int'},
        {name: 'idTemp', type: 'string'},
        {name: 'requerido', type: 'float'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiRequerimientoActividad',
            read: 'requerimientoactividads',
            update: 'uuRequerimientoActividad',
            destroy: 'ddRequerimientoActividad'
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
