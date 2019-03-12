Ext.define('GrupoBruce.view.pplanilla.PplanillaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cpplanilla',

    onAprobar: function (btn) {
        var grid = btn.up('WlistPplanilla');
        var store = grid.getStore();
        var xapro = true;

        store.each(function (item) {
            if (item.get('aprobado')) {
                xapro = false;
            }
        });
        if (xapro) {
            store.each(function (item) {
                item.set('aprobado', true);
            });
            store.sync({
                success: function (response, operation) {
                    grid.getStore().reload();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                }
            });
        }else{
            Ext.MessageBox.show({
                title: 'Error',
                msg: 'Los datos ya estan aprobados.',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.ERROR
            });
        }

    }

});
