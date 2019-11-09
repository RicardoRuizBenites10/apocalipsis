Ext.define('GrupoBruce.view.obratipo.ObraTipoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cobratipo',

    createDialog: function (record) {
        var window = new GrupoBruce.view.obratipo.FormObraTipo();
        var vm = window.getViewModel();
        vm.set('newRecord', !record);
        if (!record) {
            window.setTitle('Registrar tipo de orden de producción');
            record = new GrupoBruce.model.ObraTipo();
            record.set('idObrtip', '');
        }
        window.down('form').loadRecord(record);
    },

    addObraTipo: function () {
        this.createDialog(null);
    },

    editObraTipo: function () {
        var model = this.getViewModel().get('selectObraTipo');
        this.createDialog(model);
    },

    onSaveObraTipo: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistobratipo');
        var model = form.getRecord();
        var vmWindow = window.getViewModel();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacionobratipo').checked;
            model.set('situacion', situacion);
            if (vmWindow.get('currentObraTipo').getCount() === 0 || !vmWindow.get('newRecord')) {
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
                    msg: 'El código ingresado ya existe, intente con otro.',
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteObraTipo: function () {
        var grid = this.lookupReference('list_obratipo');
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
