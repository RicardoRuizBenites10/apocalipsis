Ext.define('GrupoBruce.view.prestamo.PrestamoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cprestamo',
    
    createDialog: function (record) {
        var window = new GrupoBruce.view.prestamo.FormPrestamo();
        if (!record) {
            window.setTitle('Registrar proceso');
            record = new GrupoBruce.model.Prestamo();
            record.set('fecha',new Date());
            record.set('idTrabajador',this.getViewModel().get('recordTrabajador').get('idTrabajador'));
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addPrestamo: function () {
        this.createDialog(null);
    },

    editPrestamo: function () {
        var model = this.getViewModel().get('selectPrestamo');
        this.createDialog(model);
    },
    
    onSavePrestamo: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistprestamo');
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
        var model = this.getViewModel().get('selectPrestamo');
        var window = Ext.create(view);
        window.getViewModel().set('recordPrestamo', model);
    },

    onPagosPrestamo : function () {
        this.createWindow('GrupoBruce.view.prestamopago.PrestamoPago');
    }

});
