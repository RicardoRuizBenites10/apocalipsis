Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    addTrabajador: function () {
        var trabajadorModel = Ext.create('GrupoBruce.model.Trabajador');
        trabajadorModel.set('idTrabajador', '');

        var window = new GrupoBruce.view.trabajador.FormTrabajador();
        window.setTitle('Registrar Trabajador');
        window.down('form').loadRecord(trabajadorModel);
    },

    editTrabajador: function () {
        var grid = this.lookupReference('list_trabajador');
        var trabajadorModel = grid.getSelection()[0];

        var window = new GrupoBruce.view.trabajador.FormTrabajador();
        window.setTitle('Editar Trabajador');
        window.down('form').loadRecord(trabajadorModel);
    },

    onSaveTrabajador: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_ltrabajador');
        var trabajadorModel = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(trabajadorModel); // update the record with the form data
            trabajadorModel.save({// save the record to the server
                success: function (user, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (user, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    onContratosTrabajador: function () {
        this.createWindow('GrupoBruce.view.contrato.ContratoTrabajador');
    },

    onHijosTrabajador: function () {
        this.createWindow('GrupoBruce.view.hijo.HijoTrabajador');
    },
    
    onVacacionsTrabajador: function () {
        this.createWindow('GrupoBruce.view.vacacion.VacacionTrabajador');
    },
    
    onEstudiosTrabajador: function(){
        this.createWindow('GrupoBruce.view.formacion.Formacion');
    },

    createWindow: function (view) {
        var grid = this.lookupReference('list_trabajador');
        var trabajadorModel = grid.getSelection()[0];
        var panelHijos = Ext.create(view);
        panelHijos.getViewModel().set('recordTrabajador', trabajadorModel);
    }

});