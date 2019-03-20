Ext.define('GrupoBruce.model.Planilla', {
    extend: 'Ext.data.Model',
    alias: 'model.Mplanilla',
    
//    idProperty: 'idConcepto',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'idConcepto', type: 'string'},
        {name: 'idPplanilla', type: 'int'},
        {name: 'idTplanilla', type: 'string'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'idTtrabajador', type: 'int'},
        {name: 'importe', type: 'float'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'uuLPlanilla',
            read: 'planillas',
            update: 'uuLPlanilla',
            destroy: 'ddPlanilla'
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
