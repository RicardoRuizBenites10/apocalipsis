Ext.define('GrupoBruce.view.mantenimientoproceso.MantenimientoProcesoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmantenimientoproceso',

    createDialog: function (record) {
        var window = new GrupoBruce.view.mantenimientoproceso.FormMantenimientoProceso();
        window.setTitle('Registrar mantenimiento');
        window.getViewModel().set('selectEstadoMantenimiento', this.getViewModel().get('selectEstadoMantenimiento'));

        var newRecord = new GrupoBruce.model.MantenimientoProceso();
        newRecord.set('idAequipo',record.get('idAequipo'));
        newRecord.set('idMantenimiento',record.get('idMantenimiento'));
        newRecord.set('idPosterior',this.getViewModel().get('selectEstadoMantenimiento').get('idPosterior'));
        
        window.down('form').loadRecord(newRecord);
    },

    addMantenimientoProceso: function () {
        var grid = this.lookupReference('list_mantenimientoProceso');
        var model = grid.getSelection()[0];
        this.createDialog(model);
    },
    
    onSaveMantenimientoProceso: function(btn){
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wmantenimientoProceso');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
            model.set('idGenerador',loggedIn.idTrabajador);
            model.save({// save the record to the server
                success: function (response, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }

});
