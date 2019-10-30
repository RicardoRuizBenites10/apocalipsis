Ext.define('GrupoBruce.view.cliente.ClienteModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcliente',
    data: {
        selectCliente: null
    },

    stores: {
        clientes: {
            type: 'Scliente',
            autoLoad: true
        }
    }

});
