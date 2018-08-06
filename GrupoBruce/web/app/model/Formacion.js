Ext.define('GrupoBruce.model.Formacion', {
    extend: 'Ext.data.Model',
    idProperty: 'formacionIdId',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'institucion', type: 'string' },
        { name: 'formacionIdId', reference:'FormacionId', unique: true },
        { name: 'tipoEstudioId', reference:'TipoEstudio' },
        { name: 'estadoEstudioId', reference:'EstadoEstudio' },
        { name: 'trabajadorId', reference:'Trabajador' }
    ]
});
