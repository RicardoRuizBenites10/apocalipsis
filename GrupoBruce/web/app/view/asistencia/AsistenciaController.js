Ext.define('GrupoBruce.view.asistencia.AsistenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casistencia',
    
    createDialog: function(){
        var window = new GrupoBruce.view.asistencia.ListMarcas();
    },
    
    onImportacionMarcas: function(){
        this.createDialog();
    },
    
    onImportacionFile: function(btn){
        var form = btn.up('form');
        var model = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (contrato, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (contrato, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }

});
