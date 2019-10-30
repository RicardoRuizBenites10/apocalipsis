Ext.define('GrupoBruce.view.cliente.ClienteController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccliente',

    createDialog: function (record) {
        var window = new GrupoBruce.view.cliente.FormCliente();
        var vm = window.getViewModel();
        vm.set('newRecord',!record);
        if (!record) {
            window.setTitle('Registrar cliente');
            record = new GrupoBruce.model.Cliente();
            record.set('idCliente', '');
        }
        window.down('form').loadRecord(record);
    },

    addCliente: function () {
        this.createDialog(null);
    },

    editCliente: function () {
        var model = this.getViewModel().get('selectCliente');
        this.createDialog(model);
    },

    onSaveCliente: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistcliente');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacioncliente').checked;
            model.set('situacion', situacion);
            model.save({// save the record to the server
                success: function (model, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.');
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteCliente: function () {
        var grid = this.lookupReference('list_cliente');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    }

});
