Ext.define('GrupoBruce.view.empresa.EmpresaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMempresa',
    data: {
        title: 'Lista de empresas',
        selectEmpresa: null
    },

    stores: {
        empresas: {
            type: 'Sempresa',
            autoLoad: true
        }
    }

});
