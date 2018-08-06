Ext.define('GrupoBruce.model.Trabajador', {
    extend: 'Ext.data.Model',
    idProperty: 'idTrabajador',
    fields: [
        { name: 'asignacion', type: 'boolean' },
        { name: 'codigo', type: 'string' },
        { name: 'idTrabajador', type: 'string' },
        { name: 'montoBase', type: 'float' },
        { name: 'montoPasaje', type: 'float' },
        { name: 'estadoTrabajadorId', reference: 'EstadoTrabajador' },
        { name: 'tipoTrabajadorId', reference: 'TipoTrabajador' },
        { name: 'formaPagoId', reference: 'FormaPago' },
        { name: 'nacionalidadId', reference: 'Nacionalidad' },
        { name: 'periocidadId', reference: 'Periocidad' },
        { name: 'personaId', reference: 'Persona', unique: true},
        { name: 'sucursalId', reference: 'Sucursal' }
    ]
});
