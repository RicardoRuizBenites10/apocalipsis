Ext.define('GrupoBruce.view.equipo.EquipoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cequipo',

    createDialog: function (record) {
        var window = new GrupoBruce.view.equipo.FormEquipo();
        if (!record) {
            window.setTitle('Registrar equipo informatico');
            record = new GrupoBruce.model.EquipoInformatico();
        }
        window.down('form').loadRecord(record);
    },

    addEquipo: function () {
        this.createDialog(null);
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
                jsonData: {tipo: newValue},
                method: 'POST',
                scope: this,
                success: function (response, opts) {
                    var responseText = Ext.decode(response.responseText);
                    var serie = responseText.serie;
                },
                failurer: function (response, opts) {
                    Ext.Msg.alert('Status', response.status);
                }
            });
        }
    }

});
