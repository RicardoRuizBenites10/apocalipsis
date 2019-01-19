Ext.define('GrupoBruce.model.Prestamo', {
    extend: 'Ext.data.Model',
    aliast: 'model.Mprestamo',
    
    idProperty: 'idPrestamo',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'fechaEntrega', type: 'date', dateFormat: 'c'},
        {name: 'idPrestamo', type: 'string'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'mpagado', type: 'float'},
        {name: 'mprestado', type: 'float'},
        {name: 'pagado', type: 'boolean'},
        {name: 'pagoCuota', type: 'float'}
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiPrestamo',
            read: 'prestamos',
            update: 'uuPrestamo',
            destroy: 'ddPrestamo'
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
