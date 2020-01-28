Ext.define('GrupoBruce.model.Obra', {
    extend: 'Ext.data.Model',
    idProperty: 'idObra',
    fields: [
        {name: 'anio', type: 'int'},
        {name: 'asientoNroorden', type: 'int'},
        {name: 'asientoRecepcion', type: 'date', dateFormat: 'c'},
        {name: 'cliente', type: 'string'},
        {name: 'detenido', type: 'date', dateFormat: 'c'},
        {name: 'entregadocli', type: 'date', dateFormat: 'c'},
        {name: 'entregadosto', type: 'date', dateFormat: 'c'},
        {name: 'ejecucion', type: 'date', dateFormat: 'c'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'fechaFin', type: 'date', dateFormat: 'c'},
        {name: 'fechaIngreso', type: 'date', dateFormat: 'c'},
        {name: 'fechaInicio', type: 'date', dateFormat: 'c'},
        {name: 'fechaSalida', type: 'date', dateFormat: 'c'},
        {name: 'gopintura', type: 'boolean'},
        {name: 'gopinturafecha', type: 'date', dateFormat: 'c'},
        {name: 'hascontratista', type: 'boolean'},
        {name: 'idEproceso', type: 'string'},
        {name: 'idEobra', type: 'string', defaultValue: 'XL'},
        {name: 'idObra', type: 'int'},
        {name: 'idObrtip', type: 'string'},
        {name: 'idProforma', type: 'string'},
        {name: 'idUsuario', type: 'string'},
        {name: 'nombre', type: 'string'},
        {name: 'nroChasis', type: 'string'},
        {name: 'numero', type: 'int'},
        {name: 'terminado', type: 'date', dateFormat: 'c'},
        {name: 'tipo', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiObra',
            read: 'obras',
            update: 'uuObra',
            destroy: 'ddObra'
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
