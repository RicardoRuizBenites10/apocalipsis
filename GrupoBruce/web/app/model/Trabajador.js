Ext.define('GrupoBruce.model.Trabajador', {
    extend: 'Ext.data.Model',
    alias: 'model.Mtrabajador',
    
    idProperty: 'idTrabajador',
    fields: [
        {name: 'asignacion', type: 'boolean'},
        {name: 'codigo', type: 'string'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'montoBase', type: 'float'},
        {name: 'montoPasaje', type: 'float'},
        { name: 'estadoTrabajadorId', reference: 'GrupoBruce.model.EstadoTrabajador', type: 'int' },
        { name: 'tipoTrabajadorId', reference: 'GrupoBruce.model.TipoTrabajador', type: 'int' },
        { name: 'formaPagoId', reference: 'GrupoBruce.model.FormaPago', type: 'int' },
        { name: 'nacionalidadId', reference: 'GrupoBruce.model.Nacionalidad', type: 'int' },
        { name: 'periocidadId', reference: 'GrupoBruce.model.Periocidad', type: 'int' },
        {name: 'personaId', reference: 'GrupoBruce.model.Persona', unique: true, type: 'string'},
        { name: 'sucursalId', reference: 'GrupoBruce.model.Sucursal' }
    ]

});
