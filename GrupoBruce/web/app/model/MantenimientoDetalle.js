Ext.define('GrupoBruce.model.MantenimientoDetalle', {
    extend: 'Ext.data.Model',
    alias: 'model.MmantenimientoDetalle',

    idProperty: 'idEinformatico',
    fields: [
        {name: 'idAequipo', type: 'int'},
        {name: 'idEinformatico', type: 'string'},
        {name: 'idMantenimiento', type: 'string'},
        {name: 'minterno', type: 'boolean'},
        {name: 'observacion', type: 'string'},
        {name: 'costo', type: 'float'}
    ],

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMantenimientoDetalle',
            read: 'mantenimientosDetalle',
            update: 'uuMantenimientoDetalle',
            destroy: 'ddMantenimientoDetalle'
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
