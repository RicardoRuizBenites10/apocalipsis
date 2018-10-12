Ext.define('GrupoBruce.view.hijo.HijoTrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Chijo',

    createDialog: function (record) {
        var view = this.getView();

        this.dialog = view.add({
            xtype: 'WformHijoTrabajador',
            viewModel: {
                data: {
                    title: record ? 'Editar hijo ' : 'Registrar hijo'
                }
            }
        });
        if (record) {
            this.dialog.down('form').loadRecord(record);
        } else {
            var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
            var newcontrato = Ext.create('GrupoBruce.model.Hijo', {
                idTrabajador: idTrabajador
            });
            this.dialog.down('form').loadRecord(newcontrato);
        }
        this.dialog.show();
    },

    addHijo: function () {
        this.createDialog(null);
    },

    editHijo: function () {
        var grid = this.lookupReference('list_hijoTrabajador');
        var hijo = grid.getSelection()[0];
        this.createDialog(hijo);
    },

    deleteHijo: function () {
        var grid = this.lookupReference('list_hijoTrabajador');
        var hijo = grid.getSelection()[0];
        hijo.erase({
            success: function (hijo, operation) {
                Ext.Msg.alert('Success', 'Eliminación exitosa.')
            },
            failure: function (hijo, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    },

    onSaveHijo: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = this.lookupReference('list_hijoTrabajador');
        var contratoModel = form.getRecord();
        
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(contratoModel); // update the record with the form data
            contratoModel.save({// save the record to the server
                success: function (hijo, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (hijo, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }

});
