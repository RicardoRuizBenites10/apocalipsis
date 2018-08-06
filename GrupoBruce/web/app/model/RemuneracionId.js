Ext.define('GrupoBruce.model.RemuneracionId', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'idContrato', type: 'int' },
        { name: 'idRemuneracion', type: 'int' },
        { name: 'idTrabajador', type: 'string' }
    ]
});
