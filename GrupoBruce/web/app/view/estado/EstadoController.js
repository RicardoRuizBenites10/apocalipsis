Ext.define('GrupoBruce.view.estado.EstadoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cestado',

    createDialog: function (record) {
        var window = new GrupoBruce.view.estado.FormEstado();
        var proceso = this.getViewModel().get('recordProceso');
        var entidad = proceso.get('entidad');
        window.getViewModel().set('recordProceso', proceso);
        if (!record) {
            window.setTitle('Registrar estado');
            record = Ext.create('GrupoBruce.model.' + entidad);
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addEstado: function () {
        this.createDialog(null);
    },

    editEstado: function () {
        var model = this.getViewModel().get('selectEstado');
        this.createDialog(model);
    },

    onSaveEstado: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_westado');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.set('idProceso', window.getViewModel().get('recordProceso').get('idProceso'));
            model.save({// save the record to the server
                success: function (model, operation) {
                    var main = Ext.getCmp('id_wmainmenu').down('treelist');
                    main.getStore().getRoot().removeAll();
                    main.getStore().reload();

                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteEstado: function () {
        var grid = this.lookupReference('list_estado');
        var model = grid.getSelection()[0];
        Ext.Ajax.request({
            url: 'relacionEstado',
            jsonData: model.data,
            method: 'POST',
            scope: this,
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                if (responseText.validacion) {
                    model.erase({
                        success: function (response, operation) {
                            var main = Ext.getCmp('id_wmainmenu').down('treelist');
                            main.getStore().getRoot().removeAll();
                            main.getStore().reload();

                            grid.getStore().reload();
                            Ext.Msg.alert('Success', 'Eliminación exitosa.');
                        },
                        failure: function (response, operation) {
                            Ext.Msg.alert('Failure', 'No se pudo eliminar.');
                        }
                    });
                    Ext.Msg.alert('Message', responseText.message);
                } else {
                    Ext.Msg.show({
                        title: 'Error',
                        msg: responseText.message,
                        icon: Ext.Msg.ERROR,
                        botones: Ext.Msg.OK
                    });
                }
            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status', response.status);
            }
        });
    }

});
