Ext.define('GrupoBruce.view.equipo.EquipoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cequipo',

    createDialog: function (record) {
        var window = new GrupoBruce.view.equipo.FormEquipo();
        window.getViewModel().set('selectEquipo', record);
        if (!record) {
            window.setTitle('Registrar proceso');
            record = new GrupoBruce.model.EquipoInformatico();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addEquipo: function () {
        this.createDialog(null);
    },

    editEquipo: function () {
        var grid = this.lookupReference('list_equipo');
        var model = grid.getSelection()[0];
        this.createDialog(model);
    },

    onSaveEquipo: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wequipo');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (formacion, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (formacion, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    generateSerie: function (combo, newValue, oldValue) {
        if (newValue) {
            Ext.Ajax.request({
                url: 'generateSerie',
                jsonData: {idTequipo: newValue},
                method: 'POST',
                scope: this,
                success: function (response, opts) {
                    var responseText = Ext.decode(response.responseText);
                    var select = this.getViewModel().get('selectEquipo');
                    var serie = select ? select.get('serie') : responseText.serie;
                    this.getViewModel().set('serie', serie);
                },
                failurer: function (response, opts) {
                    Ext.Msg.alert('Status', response.status);
                }
            });
        }
    },

    deleteEquipo: function (btn) {
        var grid = this.lookupReference('list_equipo');
        var model = grid.getSelection()[0];
        Ext.Ajax.request({
            url: 'relacionEinformatico',
            jsonData: model.data,
            method: 'POST',
            scope: this,
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                if (responseText.validacion) {
                    model.erase({
                        success: function (response, operation) {
                            grid.getStore().reload();
                            Ext.Msg.alert('Success', 'Eliminación exitosa.');
                        },
                        failure: function (response, operation) {
                            Ext.Msg.alert('Failure', 'No se pudo eliminar.');
                        }
                    });
                    Ext.Msg.alert('Message', responseText.message);
                } else {
                    Ext.Msg.show({
                        title: 'Error',
                        msg: responseText.message,
                        icon: Ext.Msg.ERROR,
                        botones: Ext.Msg.OK
                    });
                }
            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status', response.status);
            }
        });

    }

});
