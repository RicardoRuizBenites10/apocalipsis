Ext.define('GrupoBruce.view.asignacion.AsignacionController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casignacion',
    
    createDialog: function(record){
        var window = new GrupoBruce.view.asignacion.FormAsignacion();
        if(!record){
            window.setTitle('Registrar asignación');
            record = new GrupoBruce.model.AsignacionEquipo();
        }
        window.down('form').loadRecord(record);
    },
    
    addAsignacion: function(){
        this.createDialog(null);
    },
    
    onSaveAsignacion: function(btn){
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wasignacion');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
            model.set('idAsignador',loggedIn.idTrabajador);
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
