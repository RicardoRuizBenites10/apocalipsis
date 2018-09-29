Ext.define('GrupoBruce.view.contrato.ContratoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcontratoTrabajador',
    data: {
        name: 'GrupoBruce'
    },

    stores: {
        contratos: {
            type: 'ScontratoTrabajador',
            listeners: {
                beforeload: function (store) {
                    var idTrabajador = "46099060";//Ext.getCmp('filterText').value;
                    store.getProxy().setExtraParam("idTrabajador", idTrabajador);
                }
            }
            , autoLoad: true
        }
    }

});
