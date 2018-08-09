Ext.define('GrupoBruce.model.CuentaSueldo', {
    extend: 'Ext.data.Model',
    idProperty: 'idTrabajador',
    fields: [
        { name: 'idTrabajador', type: 'string' },
        { name: 'nroCuenta', type: 'string' },
        { name: 'entidadFinancieraId', reference: 'EntidadFinanciera' },
        { name: 'trabajadorId', reference: 'Trabajador', unique: true }
    ]
});