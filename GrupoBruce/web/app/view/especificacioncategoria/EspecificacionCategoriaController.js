Ext.define('GrupoBruce.view.especificacioncategoria.EspecificacionCategoriaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cespecificacioncategoria',
    addEspecificacionCategoria: function () {
        var window = new GrupoBruce.view.especificacioncategoria.FormEspecificacionCategoria();
        var rootModel = this.getViewModel().get('selectEspecificacionCategoria');
        var childModel = new GrupoBruce.model.EspecificacionCategoria();
        window.setTitle('Registrar categoría');
        childModel.set('idSupecategoria', rootModel ? rootModel.get('idEcategoria') : 'root');
        childModel.set('leaf', true);
        window.down('form').loadRecord(childModel);
    },
    editEspecificacionCategoria: function () {
        var window = new GrupoBruce.view.especificacioncategoria.FormEspecificacionCategoria();
        var model = this.getViewModel().get('selectEspecificacionCategoria');
        window.setTitle('Editar categoría especifiación');
        window.down('form').loadRecord(model);
    },
    onSaveEspecificacionCategoria: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistespecificacioncategoria');
        var model = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacionespecificacioncategoria').checked;
            model.set('situacion', situacion);
            model.set('fechaUpdate', new Date());
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
    deleteEspecificacionCategoria: function () {
        var grid = this.lookupReference('list_especificacioncategoria');
        var model = grid.getSelection()[0];
        if (model.get('leaf')) {
            model.erase({
                success: function (response, operation) {
                    grid.getStore().reload();
                    Ext.Msg.alert('Success', 'Eliminación exitosa.');
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else {
            Ext.Msg.alert('Message', 'Etapa a eliminar no debe contener subetapa(s).');
        }
    }

});
