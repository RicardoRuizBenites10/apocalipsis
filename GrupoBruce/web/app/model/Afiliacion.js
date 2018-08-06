Ext.define('GrupoBruce.model.Afiliacion', {
    extend: 'Ext.data.Model',
    idProperty: 'idTrabajador',
    fields: [
        { name: 'idTrabajador', type: 'string' },
        { name: 'nrocuspp', type: 'string' },
        { name: 'observacion', type: 'string' },
        { name: 'regimenPensionarioId', reference: 'RegimenPensionario' },
        { name: 'trabajadorId', reference: 'Trabajador', unique: true }
    ]
});
