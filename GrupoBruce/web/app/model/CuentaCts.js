Ext.define('GrupoBruce.model.CuentaCts', {
    extend: 'Ext.data.Model',
    idProperty: 'idTrabajador',
    fields: [
        { name: 'idTrabajador', type: 'string' },
        { name: 'nroCuenta', type: 'string' },
        { name: 'entidadFinancieraId', reference: 'GrupoBruce.model.EntidadFinanciera', type: 'int' },
        { name: 'trabajadorId', reference: 'GrupoBruce.model.Trabajador', unique: true, type: 'string' }
    ]
});
