Ext.define('GrupoBruce.view.periodovacacion.PeriodoVacacionController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.CperiodoVacacion',

    addPVacacion: function () {
        var periodoModel = Ext.create('GrupoBruce.model.PeriodoVacacion');
        periodoModel.set('idPVacacion', '');

        var window = new GrupoBruce.view.periodovacacion.FormPeriodoVacacion();
        window.setTitle('Registrar periodo vacación');
        window.down('form').loadRecord(periodoModel);
    },

    editPVacacion: function () {
        var grid = this.lookupReference('list_pvacacion');
        var periodoModel = grid.getSelection()[0];
        var window = new GrupoBruce.view.periodovacacion.FormPeriodoVacacion();
        window.setTitle('Editar periodo vacación');
        window.down('form').loadRecord(periodoModel);
    },

    deletePVacacion: function () {
        var grid = this.lookupReference('list_pvacacion');
        var periodoModel = grid.getSelection()[0];
        periodoModel.erase({
            success: function (hijo, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (hijo, operation) {
                Ext.Msg.alert('Failure', 'No se pudo eliminar.');
            }
        });
    },

    onSavePVacacion: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_lpvacacion');
        var periodoVacacion = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(periodoVacacion); // update the record with the form data
            var check = this.lookupReference('cerrar_periodo');
            periodoVacacion.set('cerrado',check.checked)
            periodoVacacion.save({// save the record to the server
                success: function (periodo, operation) {
                    form.reset();
                    window.destroy();
                    grid.getStore().reload();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                },
                failure: function (periodo, operation) {
                    Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.');
        }
    }

});
