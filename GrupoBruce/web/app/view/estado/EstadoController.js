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
            model.set('idProceso',window.getViewModel().get('recordProceso').get('idProceso'));
            model.save({// save the record to the server
                success: function (model, operation) {
                    var main = Ext.getCmp('id_mainMenu').down('treelist');
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
    }

});
