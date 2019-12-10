Ext.define('GrupoBruce.view.obra.ObraController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cobra',

    createDialog: function (record) {
        var window = new GrupoBruce.view.obra.FormObra();
        var vmWindow = window.getViewModel();
        var vmWindow2 = Ext.getCmp('id_wobracontratista').getViewModel();
        
        vmWindow2.set('newRegister', !record);
        vmWindow.set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar orden de producción');
            record = new GrupoBruce.model.Obra();
            record.set('idObra',0);
        }
        vmWindow2.set('recordObra', record);
        vmWindow.set('recordObra', record);
        window.down('form').loadRecord(record);
    },

    addObra: function () {
        this.createDialog(null);
    },

    editObra: function () {
        var model = this.getViewModel().get('selectObra');
        this.createDialog(model);
    },

    onSaveObra: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistobra');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var chkrpensionario = this.lookupReference('chk_rpensionario');
            model.set('hasrpensionario', chkrpensionario.checked);
            model.save({// save the record to the server
                success: function (model, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteObra: function () {
        var grid = this.lookupReference('list_obra');
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
    },

    onChangeTOP: function (combo, newValue, oldValue, eOpts) {
        var vm = this.getViewModel();
        var numOP = 1;
        Ext.Ajax.request({
            url: 'llObra',
            method: 'POST',
            async: false,
            params: {idObrtip: newValue},
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                var op = responseText.data;
                if (op !== null) {
                    numOP = op.numero + 1;
                }
            },
            failurer: function (response, opts) {
                console.log('Error 2');
            }
        });
        vm.set('numeroOP', numOP);
        vm.set('anioOP', vm.get('currentYear'));
    }

});
