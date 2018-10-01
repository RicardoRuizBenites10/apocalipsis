Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    addTrabajador: function () {
        var trabajadorModel = Ext.create('GrupoBruce.model.Trabajador');
        trabajadorModel.set('idTrabajador', '');
//        this.lookupReference('list_trabajador').getStore().add(trabajadorModel);

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
        var trabajadorModel = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(trabajadorModel); // update the record with the form data
            trabajadorModel.save({// save the record to the server
                success: function (user, operation) {
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

    onBodyTrabajador: function () {
        var panel = this.lookupReference('body_trabajador');
        console.log(Ext.data.StoreManager.lookup('Strabajador'));
        var gridTrabajador = Ext.create('GrupoBruce.view.trabajador.ListTrabajador', {height: 530});
        panel.add(gridTrabajador);
    },

    onContratosTrabajador: function () {
        var grid = this.lookupReference('list_trabajador');
        var trabajadorModel = grid.getSelection()[0];
        var panelContratos = new GrupoBruce.view.contrato.Contrato(); //Ext.create('GrupoBruce.view.contrato.Contrato').setTitle('Lista de contratos');
        panelContratos.setTitle('Lista de contratos');
        panelContratos.getViewModel().set('recordTrabajador', trabajadorModel);
//        panelContratos.down('form').loadRecord(trabajadorModel);
    }

});