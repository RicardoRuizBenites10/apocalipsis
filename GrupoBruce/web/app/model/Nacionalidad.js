Ext.define('GrupoBruce.model.Nacionalidad', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'codigo', type: 'int' },
        { name: 'descripcion', type: 'string' },
        { name: 'idNacionalidad', type: 'int' },
        { name: 'situacion', type: 'boolean' }

    ]
});
