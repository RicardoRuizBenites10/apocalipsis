Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

//    createDialog: function(record) {
//        var view = this.getView().up('panel').up('panel');
//
//        this.dialog = view.add({
//            xtype: 'WformTrabajador',
//            viewModel: {
//                data: {
//                    title: record ? 'Editar trabajador ' : 'Registrar trabajador'
//                }
//            }
//        });
//        if(record){
//            this.dialog.down('form').loadRecord(record);
//        }else{
//            var trabajadorModel = Ext.create('GrupoBruce.model.Trabajador');
//            trabajadorModel.set('idTrabajador', '');
//            this.dialog.down('form').loadRecord(trabajadorModel);
//        }
//        this.dialog.show();
//    },

//    addTrabajador: function () {
//        this.createDialog(null);
//    },
//    
//    editTrabajador: function () {
//        var grid = this.lookupReference('list_trabajador');
//        var trabajadorModel = grid.getSelection()[0];
//        this.createDialog(trabajadorModel);
//    },

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
        var grid = this.lookupReference('list_trabajador');
        var trabajadorModel = grid.getSelection()[0];
        var panelContratos = Ext.create('GrupoBruce.view.contrato.Contrato');
        panelContratos.getViewModel().set('recordTrabajador', trabajadorModel);
    },
    
    onHijosTrabajador: function(){
        var grid = this.lookupReference('list_trabajador');
        var trabajadorModel = grid.getSelection()[0];
        var panelHijos = Ext.create('GrupoBruce.view.hijo.Hijo');
        panelHijos.setTitle('Lista de Hijos');
        panelHijos.getViewModel().set('recordTrabajador', trabajadorModel);
    }

});