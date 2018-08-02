Ext.define('GrupoBruce.model.Menu', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'icono', type: 'string' },
        { name: 'idMenu', type: 'int' },
        { name: 'situacion', type: 'boolean' }

    ]
});
