Ext.define('GrupoBruce.store.ContratoTrabajador', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.ContratoTrabajador',
    alias: 'store.ScontratoTrabajador',
    
    pageSize: 15,
    remoteSort: true,
    remoteFilter: true,

    listeners: {
        beforeload: function (store) {
            var idTrabajador = "46099060";//Ext.getCmp('filterText').value;
            store.getProxy().setExtraParam("idTrabajador", idTrabajador);
        }
    }
});
