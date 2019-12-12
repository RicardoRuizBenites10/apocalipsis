Ext.define('GrupoBruce.view.obracontratista.ObraContratistaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cobracontratista',

    createDialog: function (record) {
        var window = new GrupoBruce.view.obracontratista.FormObraContratista();
        var vmGrid = Ext.getCmp('id_wobracontratista').getViewModel();
        if (!record) {
            window.setTitle('Agregar contratista');
            record = new GrupoBruce.model.ObraContratista();
            record.set('idObra', vmGrid.get('recordObra').get('idObra'));
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addObraContratista: function () {
        this.createDialog(null);
    },

    editObraContratista: function () {
        var model = this.getViewModel().get('selectObraContratista');
        this.createDialog(model);
    },

    onSaveObraContratista: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wobracontratista');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            var store = grid.getStore(), checkEP = true;
            form.updateRecord(model); // update the record with the form data
            model.set('contratista', window.getViewModel().get('selectContratista').get('nombre'));
            model.set('etapa', window.getViewModel().get('selectEtapa').get('descripcion'));

            store.each(function (item) {
                if (item.get('idEproceso') === model.get('idEproceso')) {
                    checkEP = false;
                }
            });
            if (checkEP) {
                store.add(model);

                var removedRecords = store.getRemovedRecords();
                removedRecords.forEach(function (item, index) {
                    if (model.get('idMaterial') === item.get('idMaterial')) {
                        removedRecords.splice(index, 1);
                    }
                });
                store.removed = removedRecords;
                form.reset();
                window.destroy();
            }else{
                Ext.Msg.show({
                    title: 'Error',
                    msg: 'Ya fue asignado contratista al área seleccionada.',
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.');
        }
    },

    deleteObraContratista: function () {
        var grid = Ext.getCmp('id_wobracontratista');
        var model = grid.getSelection()[0];
        grid.getStore().remove(model);
    }


});
