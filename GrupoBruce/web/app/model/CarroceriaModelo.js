Ext.define('GrupoBruce.model.CarroceriaModelo', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'codigo', type: 'string'},
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date'},
        {name: 'idCarmod', type: 'string'},
        {name: 'situacion', type: 'boolean'}
    ]
});
