Ext.define('GrupoBruce.model.Persona', {
    extend: 'Ext.data.Model',
    alias: 'model.Mpersona',
    
    idProperty: 'dni',
    fields: [
        { name: 'apMaterno', type: 'string' },
        { name: 'apPaterno', type: 'string' },
        { name: 'direccion', type: 'string' },
        { name: 'dni', type: 'string'},
        { name: 'foto', type: 'string' },
        { name: 'nacimiento', type: 'date' },
        { name: 'nombres', type: 'string' },
        { name: 'nroHijos', type: 'int' },
        { name: 'referencia', type: 'string' },
        { name: 'telefono', type: 'string' },
        { name: 'ecivilId', reference: 'GrupoBruce.model.Ecivil', type: 'int' },
        { name: 'tipoDocumentoId', reference: 'GrupoBruce.model.TipoDocumento', type: 'int' },
        { name: 'generoId', reference: 'GrupoBruce.model.Genero', type: 'int' }
    ],
    
    validators:{
        dni: ['presence',
            { type: 'length', min: 8, max: 8 }
        ],
        nroHijos: {type: 'range', min: 0, max:10 }
    }
    
});
