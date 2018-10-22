Ext.define('GrupoBruce.view.ausencia.AusenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Causencia',

    createDialog: function (record) {
        var view = this.getView();

        this.dialog = view.add({
            xtype: 'WformAusencia',
            viewModel: {
                data: {
                    title: record ? 'Editar ausencia ' : 'Registrar ausencia'
                }
            }
        });
        if (record) {
            this.dialog.down('form').loadRecord(record);
        } else {
            var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
            var nuevo = Ext.create('GrupoBruce.model.Ausencia', {
                idTrabajador: idTrabajador
            });
            this.dialog.down('form').loadRecord(nuevo);
        }
        this.dialog.show();
    },
    
    addAusencia: function(){
        this.createDialog(null);
    },
    
    editAusencia: function(){
        var grid = this.lookupReference('list_ausencia');
        var ausencia = grid.getSelection()[0];
        this.createDialog(ausencia);
    },
    
    deleteAusencia: function () {
        var grid = this.lookupReference('list_ausencia');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (ausencia, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.')
            },
            failure: function (ausencia, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    },
    
    onSaveAusencia : function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = this.lookupReference('list_ausencia');
        var model = form.getRecord();
        
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (ausencia, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (ausencia, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }
    
});
