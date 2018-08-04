Ext.define('GrupoBruce.model.Trabajador', {
    extend: 'Ext.data.Model',
    idProperty: 'idTrabajador',
    fields: [
        { name: 'asignacion', type: 'boolean' },
        { name: 'codigo', type: 'string' },
        { name: 'idTrabajador', type: 'string' },
        { name: 'montoBase', type: 'float' },
        { name: 'montoPasaje', type: 'float' },
        { name: 'estadoTrabajadorId', reference: 'EstadoTrabajador', unique: true},
        { name: 'tipoTrabajadorId', reference: 'TipoTrabajador', unique: true},
        { name: 'formaPagoId', reference: 'FormaPago', unique: true},
        { name: 'nacionalidadId', reference: 'Nacionalidad', unique: true},
        { name: 'periocidadId', reference: 'Periocidad', unique: true},
        { name: 'personaId', reference: 'Persona', unique: true},
        { name: 'sucursalId', reference: 'Sucursal', unique: true}
    ]
});
