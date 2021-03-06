Ext.define('GrupoBruce.view.contratista.ContratistaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccontratista',

    createDialog: function (record) {
        var window = new GrupoBruce.view.contratista.FormContratista();
        var vmWindow = window.getViewModel();
        vmWindow.set('newRecord', !record);
        if (!record) {
            window.setTitle('Registrar contratista');
            record = new GrupoBruce.model.Contratista();
            record.set('idContratista', '');
        }
        vmWindow.set('recordContratista', record);
        window.down('form').loadRecord(record);
        window.show();
    },

    addContratista: function () {
        this.createDialog(null);
    },

    editContratista: function () {
        var model = this.getViewModel().get('selectContratista');
        this.createDialog(model);
    },

    onSaveContratista: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistcontratista');
        var model = form.getRecord();
        var vmWindow = window.getViewModel();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacioncontratista').checked;
            model.set('situacion', situacion);
            if (vmWindow.get('currentContratista').getCount() === 0 || !vmWindow.get('newRecord')) {
                model.save({// save the record to the server
                    success: function (model, operation) {
                        grid.getStore().reload();
                        form.reset();
                        window.destroy();
                        Ext.Msg.alert('Success', 'Operación exitosa.')
                    },
                    failure: function (model, operation) {
                        Ext.Msg.alert('Failure', 'Operacion fallada.');
                    }
                });
            } else {
                Ext.Msg.show({
                    title: 'Error',
                    msg: 'El nro RUC ingresado ya existe, intente con otro.',
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteContratista: function () {
        var grid = this.lookupReference('list_contratista');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    }

});
