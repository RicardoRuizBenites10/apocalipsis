Ext.define('GrupoBruce.model.Periodo', {
    extend: 'Ext.data.Model',
    idProperty: 'idPeriodo',
    fields: [
        { name: 'cerrado', type: 'boolean' },
        { name: 'fin', type: 'date' },
        { name: 'finPlame', type: 'date' },
        { name: 'idPeriodo', type: 'int' },
        { name: 'iniPlame', type: 'date' },
        { name: 'inicio', type: 'date' },
        { name: 'situacion', type: 'boolean' },
        { name: 'tipoPeriodoId', reference: 'GrupoBruce.model.TipoPeriodo', type: 'int' },
        { name: 'tipoTrabajador', reference: 'GrupoBruce.model.TipoTrabajador', type: 'int' }
    ]
});
