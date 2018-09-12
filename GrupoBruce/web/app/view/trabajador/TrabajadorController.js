Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',
    
    addTrabajador: function () {
        var window = new GrupoBruce.view.trabajador.FormTrabajador();
        window.setTitle('Registrar Trabajador');
        window.show();
    },

    editTrabajador: function () {
        var grid = this.lookupReference('list_trabajador');
        var trabajadorModel = grid.getSelection()[0];

        var window = new GrupoBruce.view.trabajador.FormTrabajador();
        window.setTitle('Editar Trabajador');
        window.down('form').loadRecord(trabajadorModel);
        window.show();
    },

    onSaveTrabajador: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        Ext.Ajax.request({
            url: 'insertTrabajador',
            jsonData: form.getForm().getFieldValues(),
            method: 'POST',
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                window.destroy();
                Ext.Msg.show({
                    title: 'Grupo Bruce',
                    msg: responseText.message,
                    icon: responseText ? Ext.Msg.INFO : Ext.Msg.ERROR,
                    buttons: Ext.Msg.OK
                });
            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status', response.status);
            }
        });
    }

});
