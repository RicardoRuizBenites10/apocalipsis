Ext.define('GrupoBruce.view.asistencia.AsistenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casistencia',

    createDialog: function (record) {
        var window = new GrupoBruce.view.marca.FormMarca();
        if (!record) {
            window.setTitle('Registrar marcación');
            var asistencia = this.getViewModel().get('selectAsistencia');
            var record = Ext.create('GrupoBruce.model.Marca', {
                idTrabajador: asistencia.get('idTrabajador'),
                fecha: asistencia.get('fecha')
            });
        }
        window.down('form').loadRecord(record);
    },

    addMarcacion: function () {
        this.createDialog(null);
    },

    onSaveMarcacion: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (response, operation) {
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.');
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    onMarcaImport: function () {
        var window = new GrupoBruce.view.marca.ListMarcaImport();
    },
    
    onProcesar: function(){
        
    }
    
});
