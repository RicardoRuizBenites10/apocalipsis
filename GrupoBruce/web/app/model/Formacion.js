Ext.define('GrupoBruce.model.Formacion', {
    extend: 'Ext.data.Model',
    idProperty: 'formacionIdId',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'institucion', type: 'string' },
        { name: 'formacionIdId', reference:'GrupoBruce.model.FormacionId', unique: true },
        { name: 'tipoEstudioId', reference:'GrupoBruce.model.TipoEstudio', type: 'int' },
        { name: 'estadoEstudioId', reference:'GrupoBruce.model.EstadoEstudio', type: 'int' },
        { name: 'trabajadorId', reference:'GrupoBruce.model.Trabajador', type: 'string' }
    ]
});
