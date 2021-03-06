Ext.define('GrupoBruce.view.proceso.ProcesoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cproceso',
    
    createDialog: function (record) {
        var window = new GrupoBruce.view.proceso.FormProceso();
        if (!record) {
            window.setTitle('Registrar proceso');
            record = new GrupoBruce.model.Proceso();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addProceso: function () {
        this.createDialog(null);
    },

    editProceso: function () {
        var model = this.getViewModel().get('selectProceso');
        this.createDialog(model);
    },
    
    deleteProceso: function () {
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
    
    onSaveProceso: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wproceso');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
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
        var model = this.getViewModel().get('selectProceso');
        var window = Ext.create(view);
        window.getViewModel().set('recordProceso', model);
    },

    onEtapasProceso : function () {
        this.createWindow('GrupoBruce.view.estado.Estado');
    }

});