Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    addTrabajador: function () {
        var grid = this.lookupReference('gridTrabajador');
        
        var window = new GrupoBruce.view.trabajador.Form({
            title: 'REGISTRO TRABAJADOR'
        });
        window.show();
    },

    verTrabajador: function () {

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
                    text: 'CANCELAR',
                    listeners: {
                        click: function () {
                            this.up('window').destroy();
                        }
                    }
                }, {
                    text: 'GRABAR',
                    formBind: true,
                    listeners: {
                        click: function () {
                            Ext.Ajax.request({
                                url: 'insertTrabajador',
                                jsonData: form.getForm().getFieldValues(),
                                method: 'POST',
                                success: function (response, opts) {
                                    var responseText = Ext.decode(response.responseText);
                                    window.destroy();
//                                    Ext.Msg.show({
//                                        title: 'Grupo Bruce',
//                                        msg: responseText.message,
//                                        icon: responseText ? Ext.Msg.INFO : Ext.Msg.ERROR,
//                                        buttons: Ext.Msg.OK
//                                    });
                                    grid.getStore().reload();
                                },
                                failurer: function (response, opts) {
                                    Ext.Msg.alert('Status', response.status);
                                }
                            });
                        }
                    }
                }]
        });

        window.show();
    },
    
    
    onCancelarTrabajador: function(){
        var form = this.lookupReference('ww_trabajador');
        form.destroy();
    },
    
    onSaveTrabajador: function(){
        Ext.Msg.alert('Titulo','cuerpo');
    }
    
});
