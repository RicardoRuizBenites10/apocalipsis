Ext.define('GrupoBruce.view.etapaproceso.EtapaProcesoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cetapaproceso',

    createDialog: function (record) {
        var window = new GrupoBruce.view.etapaproceso.FormEtapaProceso();
        if (!record) {
            window.setTitle('Registrar área de producción');
            record = new GrupoBruce.model.EtapaProceso();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addEtapaProceso: function () {
        this.createDialog(null);
    },

    editEtapaProceso: function () {
        var model = this.getViewModel().get('selectEtapaProceso');
        this.createDialog(model);
    },

    onSaveEtapaProceso: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wetapaproceso');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var pasa = this.lookupReference('chk_pasabus').checked,
                situacion = this.lookupReference('chk_situacionetapaproceso').checked;
            model.set('pasaBus', pasa);
            model.set('situacion',situacion);
            model.save({// save the record to the server
                success: function (model, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.');
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteEtapaProceso: function () {
        var grid = this.lookupReference('list_etapaproceso');
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
