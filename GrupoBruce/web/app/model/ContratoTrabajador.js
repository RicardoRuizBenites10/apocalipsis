Ext.define('GrupoBruce.model.ContratoTrabajador', {
    extend: 'Ext.data.Model',
    
    idProperty: 'contratoTrabajadorIdId',
    fields: [
        { name: 'fechaCese', type: 'date' },
        { name: 'fechaFin', type: 'date' },
        { name: 'fechaInicio', type: 'date' },
        { name: 'contratoTrabajadorIdId', reference: 'GrupoBruce.model.ContratoTrabajadorId', unique: true },
        { name: 'estadoContratoId', reference: 'GrupoBruce.model.EstadoContrato', type: 'int' },
        { name: 'tipoContratoId', reference: 'GrupoBruce.model.TipoContrato', type: 'int' },
        { name: 'tiempoContratoId', reference: 'GrupoBruce.model.TiempoContrato', type: 'int' },
        { name: 'trabajadorId', reference: 'GrupoBruce.model.Trabajador', type: 'string' }
    ]
});
