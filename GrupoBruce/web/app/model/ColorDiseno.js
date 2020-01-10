Ext.define('GrupoBruce.model.ColorDiseno', {
    extend: 'Ext.data.Model',
    alias: 'model.Mcolordiseno',

    idProperty: 'idCdiseno',
    fields: [
        {name: 'denominacion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idCdiseno', type: 'string'},
        {name: 'hasformula', type: 'boolean'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiColorDiseno',
            read: 'colorDisenos',
            update: 'uuColorDiseno',
            destroy: 'ddColorDiseno'
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
