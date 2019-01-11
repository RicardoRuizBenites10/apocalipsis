Ext.define('GrupoBruce.view.entidadfinanciera.EntidadFinancieraModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMentidadfinanciera',

    data: {
        title: 'Lista de entidades financieras',
        selectEntidadFinanciera: null
    },

    stores: {
        entidadsFinanciera: {
            type: 'SentidadFinanciera',
            autoLoad: true
        }
    }

});
