Ext.define('GrupoBruce.model.ColorFormula', {
    extend: 'Ext.data.Model',
    alias: 'model.Mcolorformula',

    idProperty: 'idMaterial',
    fields: [
        {name: 'cantidad', type: 'float'},
        {name: 'colordiseno', type: 'string'},
        {name: 'idCdiseno', type: 'string'},
        {name: 'idMaterial', type: 'int'},
        {name: 'material', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLColorFormula',
            read: 'colorFormulas',
            update: 'uuLColorFormula',
            destroy: 'ddLColorFormula'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            allowSingle: false,
            writeAllFields: true
        }
    }
});
