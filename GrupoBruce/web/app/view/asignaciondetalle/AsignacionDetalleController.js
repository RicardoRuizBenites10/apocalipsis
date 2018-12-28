Ext.define('GrupoBruce.view.asignaciondetalle.AsignacionDetalleController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casignaciondetalle',

    createDialog: function (record) {
        var window = new GrupoBruce.view.asignaciondetalle.FormAsignacionDetalle();
        if (!record) {
            window.setTitle('Asignar equipo informático');
            record = new GrupoBruce.model.AsignacionDetalle();
            record.set('idAequipo', this.getViewModel().get('recordAsignacion').get('idAequipo'));
        }
        window.down('form').loadRecord(record);
    },

    addAsignacionDetalle: function () {
        console.log(this.getViewModel().get('recordAsignacion').get('idAequipo'));
        this.createDialog(null);
    },

    editAsignacionDetalle: function () {
        var grid = this.lookupReference('list_asignacionDetalle');
        var model = grid.getSelection()[0];
        this.createDialog(model);
    },

    onSaveAsignacionDetalle: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wasignacionDetalle');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            Ext.Ajax.request({
                url: 'validaRAsignacionEquipo',
                jsonData: model.getData(true),
                method: 'POST',
                scope: this,
                success: function (response, opts) {
                    var responseText = Ext.decode(response.responseText);
                    if (responseText.validado) {

                        model.set('einformatico', window.getViewModel().get('selectEquipo').get('denominacion'));
                        model.save({// save the record to the server
                            success: function (response, operation) {
                                grid.getStore().reload();
                                form.reset();
                                window.destroy();
                                Ext.Msg.alert('Success', 'Operación exitosa.')
                            },
                            failure: function (response, operation) {
                                Ext.Msg.alert('Failure', 'Operacion fallada.')
                            }
                        });
                    } else {
                        Ext.Msg.show({
                            title: 'Error',
                            msg: "No se puede asignar mas de 1 equipo del mismo tipo.",
                            icon: Ext.Msg.ERROR,
                            botones: Ext.Msg.OK
                        });
                    }
                },
                failurer: function (response, opts) {
                    Ext.Msg.alert('Status', response.status);
                }
            });


        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteAsignacionDetalle: function (btn) {
        var grid = this.lookupReference('list_asignacionDetalle');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'No se pudo eliminar.');
            }
        });
    }

});
