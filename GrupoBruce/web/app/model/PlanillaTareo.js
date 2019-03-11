Ext.define('GrupoBruce.model.PlanillaTareo', {
    extend: 'Ext.data.Model',
    alias: 'model.MplanillaTareo',

    idProperty: 'idTrabajador',
    fields: [
        {name: 'adelanto', type: 'float'},
        {name: 'aprobado', type: 'boolean'},
        {name: 'devolucion', type: 'float'},
        {name: 'diasPeriodo', type: 'int'},
        {name: 'diasPlame', type: 'int'},
        {name: 'diasTrabajado', type: 'int'},
        {name: 'empRmv', type: 'float'},
        {name: 'flagAfp', type: 'boolean'},
        {name: 'flagAsig', type: 'boolean'},
        {name: 'haberBasico', type: 'float'},
        {name: 'hextra25', type: 'float'},
        {name: 'hextra35', type: 'float'},
        {name: 'horasDesct', type: 'float'},
        {name: 'idPplanilla', type: 'int'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'movilidad', type: 'float'},
        {name: 'otrosDesct', type: 'float'},
        {name: 'prestamo', type: 'float'},
        {name: 'procesado', type: 'boolean'},
        {name: 'reintegro', type: 'float'},
        {name: 'trabajador', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiplanillaTareo',
            read: 'planillasTareo',
            update: 'uuplanillaTareo',
            destroy: 'ddplanillaTareo'
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