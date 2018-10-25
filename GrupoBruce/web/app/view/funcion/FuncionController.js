Ext.define('GrupoBruce.view.funcion.FuncionController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cfuncion',
    
    createDialog: function (record) {
        var view = this.getView();

        this.dialog = view.add({
            xtype: 'WformFuncion',
            viewModel: {
                data: {
                    title: record ? 'Editar función ' : 'Registrar función'
                }
            }
        });
        if (record) {
            this.dialog.down('form').loadRecord(record);
        } else {
            var idArea = this.getViewModel().get('recordCargo').get('idArea');
            var idCargo = this.getViewModel().get('recordCargo').get('idCargo');
            var newfuncion = Ext.create('GrupoBruce.model.Funcion', {
                idArea: idArea,
                idCargo: idCargo
            });
            this.dialog.down('form').loadRecord(newfuncion);
        }
        this.dialog.show();
    },
    
    addFuncion: function(){
        this.createDialog(null);
    },
    
    editFuncion: function(){
        var grid = this.lookupReference('list_funcion');
        var model = grid.getSelection()[0];
        this.createDialog(model);
    },
    
    onSaveFuncion: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = this.lookupReference('list_funcion');
        var model = form.getRecord();
        
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (funcion, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (funcion, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteFuncion: function () {
        var grid = this.lookupReference('list_funcion');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (funcion, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (funcion, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    }
    
    
});
