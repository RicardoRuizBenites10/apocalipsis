Ext.define('GrupoBruce.view.asignaciondetalle.AsignacionDetalleController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casignaciondetalle',
    
    createDialog: function(record){
        var window = new GrupoBruce.view.asignaciondetalle.FormAsignacionDetalle();
        if(!record){
            window.setTitle('Registrar asignación de equipo');
            record = new GrupoBruce.model.AsignacionDetalle();
        }
        window.down('form').loadRecord(record);
    },
    
    addAsignacionDetalle: function(){
        this.createDialog(null);
    },
    
    editAsignacionDetalle: function(){
        var grid = this.lookupReference('list_asignacion');
        var model = grid.getSelection()[0];
        this.createDialog(model);
    },
    
    onSaveAsignacionDetalle: function(btn){
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
