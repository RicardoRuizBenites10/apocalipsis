Ext.define('GrupoBruce.model.Trabajador', {
    extend: 'Ext.data.Model',
    alias: 'model.Mtrabajador',
    
    idProperty: 'idTrabajador',
    fields: [
        { name: 'apMaterno', type: 'string' },
        { name: 'apPaterno', type: 'string' },
        {name: 'codigo', type: 'string'},
        { name: 'direccion', type: 'string' },
        { name: 'foto', type: 'string' },
        { name: 'fotoB64', type: 'string' },
        {name: 'idTrabajador', type: 'string'},
        {name: 'montoBase', type: 'float'},
        {name: 'montoPasaje', type: 'float'},
        { name: 'nacimiento', type: 'date', dateFormat: 'c' },
        { name: 'nombres', type: 'string' },
        { name: 'nrocuentaCts', type: 'string' },
        { name: 'nrocusppAfiliacion', type: 'string' },
        { name: 'nroHijos', type: 'int' },
        { name: 'nrocuentaSueldo', type: 'string' },
        { name: 'referencia', type: 'string' },
        { name: 'telefono', type: 'string' },
        { name: 'ultimaAlta', type: 'date' },
        
        { name: 'idNacionalidad', type:'int' },
        { name: 'idTdocumento', type:'string' },
        { name: 'idGenero', type:'int' },
        { name: 'idEcivil', type:'int' },
        { name: 'idTtrabajador', type:'int' },
        { name: 'idEtrabajador', type:'int' },
        { name: 'idFpago', type:'int' },
        { name: 'idPeriocidad', type:'int' },
        { name: 'idEmpresa', type:'string' },
        { name: 'idSucursal', type:'string' },
        { name: 'idEfSueldo', type:'string' },
        { name: 'idEfCts', type:'string' },
        { name: 'idRpensionario', type:'string' },
        { name: 'idComisionrp', type:'int' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'trabajadors',
            create: 'insertTrabajador',
            update: 'updateTrabajador',
            delete: 'deleteTrabajador'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: true 
        }
        
    },
    
    validators:{
        idTrabajador: ['presence',
            { type: 'length', min: 8, max: 8 }
        ],
        nroHijos: {type: 'range', min: 0, max:10 }
    }

});
