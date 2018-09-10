Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    addTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Nuevo trabajador.');
    },

    editTrabajador: function () {
        var grid = this.lookupReference('gridTrabajador');
        var trabajadorModel = grid.getSelection()[0];

        var form = new GrupoBruce.view.trabajador.Form();
        form.loadRecord(trabajadorModel);

        var window = new Ext.window.Window({
            title: 'TRABAJADOR',

            width: 560,
            modal: true,
            closable: false,
            resizable: false,

            items: [form],

            buttons: [{
                    text: 'CANCELAR'
                }, {
                    text: 'GRABAR',
                    listeners: {
                        click: function () {
//                            var data = form.getForm().getValues();
                            Ext.Ajax.request({
                                url: 'insertTrabajador',
                                jsonData: form.getForm().getValues(),
                                method: 'POST',
                                scope: this,
                                success: this.onTrabajadorSuccess,
                                failurer: this.onTrabajadorFailure
                            });
                        }
                    }
                }]
        });

        window.show();
    },

    verTrabajador: function () {

    },

    onTrabajadorSuccess: function (response, opts) {
        var responseText = Ext.decode(response.responseText);
        Ext.Msg.show({
            title: 'Error',
            msg: responseText.message,
            icon: Ext.Msg.ERROR,
            botones: Ext.Msg.OK
        });

    },

    onTrabajadorFailure: function (response, opts) {
        Ext.Msg.alert('Status', response.status);
    }

});
