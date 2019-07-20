Ext.define('GrupoBruce.view.proveedor.ProveedorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMproveedor',
    data: {
        titulo: 'Lista de proveedores'
    },
    
    stores: {
        proveedors: {
            type: 'Sproveedor',
            autoLoad: true
        }
    }

});
