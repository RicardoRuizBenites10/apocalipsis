Ext.define('GrupoBruce.model.PeriodoPlanilla', {
    extend: 'Ext.data.Model',
    alias: 'model.MperiodoPlanilla',

    idProperty: 'idPplanilla',
    fields: [
        {name: 'cerrado', type: 'boolean'},
        {name: 'denominacion', type: 'string'},
        {name: 'diasDominical', type: 'int'},
        {name: 'diasPeriodo', type: 'int'},
        {name: 'fin', type: 'date', dateFormat: 'c'},
        {name: 'finPlame', type: 'date', dateFormat: 'c'},
        {name: 'idPplanilla', type: 'string'},
        {name: 'idTtrabajador', type: 'int'},
        {name: 'iniPlame', type: 'date', dateFormat: 'c'},
        {name: 'inicio', type: 'date', dateFormat: 'c'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiPeriodoPlanilla',
            read: 'periodosPlanilla',
            update: 'uuPeriodoPlanilla',
            destroy: 'ddPeriodoPlanilla'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
