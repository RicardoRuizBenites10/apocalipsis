Ext.define('GrupoBruce.view.contrato.ContratoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcontratoTrabajador',
    
    data: {
        recordTrabajador: null,
        my_idTrabajador: '46099060'
    },

    stores: {
        contratos: {
            type: 'ScontratoTrabajador',
            listeners: {
                beforeload: function (store) {
                    var idTrabajador = '{my_idTrabajador}';//Ext.getCmp('filterText').value;
                    store.getProxy().setExtraParam("idTrabajador", idTrabajador);
                }
            }
            , autoLoad: true
        }
    }

});
