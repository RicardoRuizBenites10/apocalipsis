Ext.define('GrupoBruce.view.plantilla.PlantillaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cplantilla',

    createDialog: function (record) {
        var window = new GrupoBruce.view.plantilla.FormPlantilla();
        window.getViewModel().set('recordCarroceria', record);
        window.down('form').loadRecord(record);
    },

    addPlantilla: function () {
        this.createDialog(null);
    },

    editPlantilla: function () {
        var model = this.getViewModel().get('selectCarroceria');
        this.createDialog(model);
    },

    onSavePlantilla: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wtipotrabajador');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var chkrpensionario = this.lookupReference('chk_rpensionario'),
                    chkctacts = this.lookupReference('chk_ctacts'),
                    chkdiario = this.lookupReference('chk_jornaldiario');
            model.set('hasrpensionario', chkrpensionario.checked);
            model.set('hasctacts', chkctacts.checked);
            model.set('jornalDiario', chkdiario.checked);
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

    deletePlantilla: function () {
        var grid = this.lookupReference('list_tipoTrabajador');
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

    createWindow: function (view) {
        var model = this.getViewModel().get('recordCarroceria');
        var window = Ext.create(view);
        window.getViewModel().set('recordCarroceria', model);
    },

    onPlantillaChange: function () {
        this.createWindow('GrupoBruce.view.plantilla.FormPlantillaChange');
    },

    changeCheck: function (check, newValue, oldValue) {
        var vm = check.up('grid').up('panel').getViewModel();
        var store = vm.get('especificacions');
        if (newValue) {
            store.addFilter([{
                    property: 'ID_ECATEGORIA',
                    operator: 'in',
                    value: vm.get('categorias')
                }]);
        } else {
            store.clearFilter();
        }
    },

    selectPicker: function (picker, record) {
        var codigos = [];
        codigos.push(record.get('idEcategoria'));
        this.childsString(record, codigos);
        picker.up('grid').up('panel').getViewModel().set('categorias', codigos.toString());
    },

    childsString: function (record, codigos) {
        var childs = record.childNodes;
        if (childs.length === 0) {
            codigos.push(record.get('idEcategoria'));
        } else {
            for (var i = 0; i < childs.length; i++) {
                this.childsString(childs[i], codigos);
            }
        }
    },

    savePlantillaChange: function (btn) {
        var window = btn.up('window');
        var selection = btn.up('grid').getSelection();

        if (selection.length) {
            let name = '';
            selection.map(item => {
                name += item.get('descripcion') + '<br>';
            });
            Ext.Msg.alert('Selected Record', name);
        }
        window.close();
    }

});
