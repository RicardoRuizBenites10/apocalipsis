Ext.define('GrupoBruce.model.ContratoTrabajador', {
    extend: 'Ext.data.Model',
    idProperty: 'contratoTrabajadorIdId',
    fields: [
        { name: 'fechaCese', type: 'date' },
        { name: 'fechaFin', type: 'date' },
        { name: 'fechaInicio', type: 'date' },
        { name: 'contratoTrabajadorIdId', reference: 'ContratoTrabajadorId', unique: true },
        { name: 'estadoContratoId', reference: 'EstadoContrato' },
        { name: 'tipoContratoId', reference: 'TipoContrato' },
        { name: 'tiempoContratoId', reference: 'TiempoContrato'},
        { name: 'TrabajadorId', reference: 'Trabajador' }
    ]
});
