Ext.define('GrupoBruce.model.Hijo', {
    extend: 'Ext.data.Model',
    idProperty: 'idHijo',
    fields: [
        { name: 'dni', type: 'string' },
        { name: 'idHijo', type: 'int' },
        { name: 'nacimiento', type: 'date' },
        { name: 'nombres', type: 'string' },
        { name: 'generoId', reference: 'Genero', unique:true},
        { name: 'trabajadorId', reference: 'Trabajador'}
    ]
});
