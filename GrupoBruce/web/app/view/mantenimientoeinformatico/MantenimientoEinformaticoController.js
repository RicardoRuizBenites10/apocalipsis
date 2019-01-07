Ext.define('GrupoBruce.view.mantenimientoeinformatico.MantenimientoEinformaticoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmantenimientoeinformatico',
    
    createDialog: function(record){
        var window = new GrupoBruce.view.mantenimientoeinformatico.FormMantenimientoEinformatico();
        if(!record){
            window.setTitle('Registrar mantenimiento');
            record = new GrupoBruce.model.Mantenimiento();
            record.set('idAequipo', this.getViewModel().get('recordAsignacion').get('idAequipo'));
        }
        window.down('form').loadRecord(record);
    },
    
    addMantenimientoEinformatico: function(){
        this.createDialog(null);
    },
    
    onSaveMantenimiento: function(btn){
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wmantenimientoEinformatico');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
            model.set('idGenerador',loggedIn.idUsuario);
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
    
    seguimientoMantenimientoEinformatico: function(){
        var window = new GrupoBruce.view.mantenimientoproceso.ListSeguimientoProceso();
        window.getViewModel().set('selectMantenimiento',this.getViewModel().get('selectMantenimientoEinformatico'));
        window.show();
    }
    
});
