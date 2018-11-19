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
    
    editAsignacion: function(){
        var grid = this.lookupReference('list_asignacion');
        var model = grid.getSelection()[0];
        this.createDialog(model);
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
            model.set('recepcionador',window.getViewModel().get('selectRecepcionador').get('nombresCompletos'));
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
    },
    
    createWindow: function (view) {
        var grid = this.lookupReference('list_asignacion');
        var model = grid.getSelection()[0];
        var window = Ext.create(view);
        window.getViewModel().set('recordAsignacion', model);
    },

    onAsignacion: function () {
        this.createWindow('GrupoBruce.view.asignaciondetalle.AsignacionDetalle');
    },
    
    onMantenimiento: function(){
        this.createWindow('GrupoBruce.view.mantenimientoeinformatico.MantenimientoEinformatico');
    }
    
});
