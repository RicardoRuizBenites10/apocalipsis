Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    addTrabajador: function () {
        var window = new GrupoBruce.view.trabajador.FormTrabajador();
        window.setTitle('Registrar Trabajador');
    },

    editTrabajador: function () {
        var grid = this.lookupReference('list_trabajador');
        var trabajadorModel = grid.getSelection()[0];

        var window = new GrupoBruce.view.trabajador.FormTrabajador();
        window.setTitle('Editar Trabajador');
        window.down('form').loadRecord(trabajadorModel);
    },

    onSaveTrabajador: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var record = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(record); // update the record with the form data
            record.save({// save the record to the server
                success: function (user,action) {
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (user) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }


//        Ext.Ajax.request({
//            url: 'updateTrabajador',
//            jsonData: form.getForm().getFieldValues(),
//            method: 'POST',
//            success: function (response, opts) {
//                var responseText = Ext.decode(response.responseText);
//                window.destroy();
//                Ext.Msg.show({
//                    title: 'Grupo Bruce',
//                    msg: responseText.message,
//                    icon: responseText ? Ext.Msg.INFO : Ext.Msg.ERROR,
//                    buttons: Ext.Msg.OK
//                });
//            },
//            failurer: function (response, opts) {
//                Ext.Msg.alert('Status', response.status);
//            }
//        });
    }

});