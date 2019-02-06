Ext.define('GrupoBruce.view.textralaboral.TextralaboralController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctextralaboral',

    createDialog: function (record) {
        var window = new GrupoBruce.view.textralaboral.FormTextralaboral();
        if (!record) {
            window.setTitle('Registrar horas extras');
            record = new GrupoBruce.model.Textralaboral();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addTextralaboral: function () {
        this.createDialog(null);
    },

    editTextralaboral: function () {
        var model = this.getViewModel().get('selectTextralaboral');
        this.createDialog(model);
    },

    deleteTextralaboral: function () {
        var grid = this.lookupReference('list_proceso');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'No se pudo eliminar.');
            }
        });
    },

    onSaveTextralaboral: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlisttextralaboral');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var horas = window.lookupReference('hrs_extra').value;
            model.set('horaSalida', Ext.Date.add(model.get('horaInicio'), Ext.Date.HOUR, horas));
            model.save({// save the record to the server
                success: function (model, operation) {
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

    createWindow: function (view) {
        var model = this.getViewModel().get('selectTextralaboral');
        var window = Ext.create(view);
        window.getViewModel().set('recordTextralaboral', model);
    },

    onEtapasTextralaboral: function () {
        this.createWindow('GrupoBruce.view.estado.Estado');
    }

});
