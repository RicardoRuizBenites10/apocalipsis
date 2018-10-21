Ext.define('GrupoBruce.view.vacacion.VacacionTrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.CvacacionTrabajador',
    
    createDialog: function(record){
        var view = this.getView();

        this.dialog = view.add({
            xtype: 'WformVacacionTrabajador',
            viewModel: {
                data: {
                    title: record ? 'Editar vacación ' : 'Registrar vacación'
                }
            }
        });
        this.getViewModel().set('initialValue',1);
        if (record) {
            this.dialog.down('form').loadRecord(record);
        } else {
            var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
            var newcontrato = new GrupoBruce.model.Vacacion();
            newcontrato.set('idTrabajador',idTrabajador);
            newcontrato.set('idPVacacion',);
            this.dialog.down('form').loadRecord(newcontrato);
        }
        this.dialog.show();
    },
    
    addVacacion: function(){
        this.createDialog(null);
    },
    
    editVacacion: function(){
        var grid = this.lookupReference('list_vacacionTrabajador');
        var vacacion = grid.getSelection()[0];
        this.createDialog(vacacion);
    },
    
    deleteVacacion: function(){
        var grid = this.lookupReference('list_vacacionTrabajador');
        var vacacion = grid.getSelection()[0];
        vacacion.erase({
            success: function (vacacion, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.')
            },
            failure: function (vacacion, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    },
    
    onSaveVacacion: function(btn){
        var window = btn.up('window');
        var form = btn.up('form');
        var grid = this.lookupReference('list_vacacionTrabajador');
        var vacacionModel = form.getRecord();
        vacacionModel.set('fechaBase',this.getViewModel().get('fecha_base'));
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(vacacionModel); // update the record with the form data
            vacacionModel.save({// save the record to the server
                success: function (vacacion, operation) {
                    form.reset();
                    window.destroy();
                    grid.getStore().reload();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (vacacion, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }

});
