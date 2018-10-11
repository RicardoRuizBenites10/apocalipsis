Ext.define('GrupoBruce.view.contrato.ContratoTrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.CcontratoTrabajador',

    createDialog: function (record) {
        var view = this.getView();

        this.dialog = view.add({
            xtype: 'WformContratoTrabajador',
            viewModel: {
                data: {
                    title: record ? 'Editar contrato ' : 'Registrar contrato'
                }
            }
        });
        if (record) {
            this.dialog.down('form').loadRecord(record);
        } else {
            var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
            var newcontrato = Ext.create('GrupoBruce.model.ContratoTrabajador', {
                idTrabajador: idTrabajador
            });
            this.dialog.down('form').loadRecord(newcontrato);
        }
        this.dialog.show();
    },

    addContrato: function () {
        var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
        Ext.Ajax.request({
            url: 'validaRContrato',
            jsonData: {"idTrabajador": idTrabajador},
            method: 'POST',
            scope: this,
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                var fechaInicio = responseText.inicio !== null ? Ext.Date.add(new Date(responseText.inicio), Ext.Date.DAY, 2) : new Date();
                if (responseText.success) {
                    this.getViewModel().set('currentDate',fechaInicio);
                    this.createDialog(null);
                } else {
                    Ext.Msg.show({
                        title: 'Error',
                        msg: "No se puede registrar nuevo contrato",
                        icon: Ext.Msg.ERROR,
                        botones: Ext.Msg.OK
                    });
                }

            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status', response.status);
            }
        });
    },

    editContrato: function () {
        var grid = this.lookupReference('list_contratoTrabajador');
        var contrato = grid.getSelection()[0];
        this.getViewModel().set('currentDate',contrato.get('fechaInicio'));
        this.createDialog(contrato);
    },

    onSaveContrato: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var contratoModel = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(contratoModel); // update the record with the form data
            contratoModel.save({// save the record to the server
                success: function (contrato, operation) {
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
        var grid = this.lookupReference('list_contratoTrabajador');
        grid.getStore().reload();
    }

});
