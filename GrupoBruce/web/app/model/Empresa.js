Ext.define('GrupoBruce.model.Empresa', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idEmpresa', type: 'string' },
        { name: 'situacion', type: 'boolean' }

    ]
});
