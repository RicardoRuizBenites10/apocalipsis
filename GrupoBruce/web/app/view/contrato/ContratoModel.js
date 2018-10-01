Ext.define('GrupoBruce.view.contrato.ContratoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcontratoTrabajador',
    
    data: {
        recordTrabajador: null
    },

    stores: {
        contratos: {
            type: 'ScontratoTrabajador',
            listeners: {
                beforeload: function (store) {
                    var idTrabajador = '{my_idTrabajador}';//Ext.getCmp('filterText').value;
                    store.getProxy().setExtraParam("idTrabajador", '{my_idTrabajador}');
                }
            }
            , autoLoad: true
        }
    }

});
