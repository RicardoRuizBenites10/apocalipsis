Ext.define('GrupoBruce.model.Trabajador', {
    extend: 'Ext.data.Model',
    alias: 'model.Mtrabajador',
    
    idProperty: 'idTrabajador',
    fields: [
        { name: 'apMaterno', type: 'string' },
        { name: 'apPaterno', type: 'string' },
        {name: 'asignacion', type: 'boolean'},
        {name: 'codigo', type: 'string'},
        { name: 'direccion', type: 'string' },
        { name: 'foto', type: 'string' },
        {name: 'idTrabajador', type: 'string'},
        {name: 'montoBase', type: 'float'},
        {name: 'montoPasaje', type: 'float'},
        { name: 'nacimiento', type: 'date' },
        { name: 'nombres', type: 'string' },
        { name: 'nroHijos', type: 'int' },
        { name: 'referencia', type: 'string' },
        { name: 'telefono', type: 'string' },
        
        { name: 'ecivilId', reference: 'GrupoBruce.model.Ecivil', type: 'int' },
        { name: 'tipoDocumentoId', reference: 'GrupoBruce.model.TipoDocumento', type: 'int' },
        { name: 'generoId', reference: 'GrupoBruce.model.Genero', type: 'int' },
        { name: 'estadoTrabajadorId', reference: 'GrupoBruce.model.EstadoTrabajador', type: 'int' },
        { name: 'tipoTrabajadorId', reference: 'GrupoBruce.model.TipoTrabajador', type: 'int' },
        { name: 'formaPagoId', reference: 'GrupoBruce.model.FormaPago', type: 'int' },
        { name: 'nacionalidadId', reference: 'GrupoBruce.model.Nacionalidad', type: 'int' },
        { name: 'periocidadId', reference: 'GrupoBruce.model.Periocidad', type: 'int' },
        { name: 'sucursalId', reference: 'GrupoBruce.model.Sucursal' }
    ],
    
    validators:{
        idTrabajador: ['presence',
            { type: 'length', min: 8, max: 8 }
        ],
        nroHijos: {type: 'range', min: 0, max:10 }
    }

});
