Ext.define('GrupoBruce.model.Persona', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'apMaterno', type: 'string' },
        { name: 'apPaterno', type: 'string' },
        { name: 'direccion', type: 'string' },
        { name: 'foto', type: 'string' },
        { name: 'nacimiento', type: 'date' },
        { name: 'nombres', type: 'string' },
        { name: 'nroHijos', type: 'int' },
        { name: 'referencia', type: 'string' },
        { name: 'telefono', type: 'string' }

    ]
});
