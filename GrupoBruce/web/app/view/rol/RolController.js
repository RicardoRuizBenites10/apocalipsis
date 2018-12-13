Ext.define('GrupoBruce.view.rol.RolController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Crol',
    
    createDialog: function (record) {
        var window = new GrupoBruce.view.rol.FormRol();
        if (!record) {
            window.setTitle('Registrar rol');
            var record = Ext.create('GrupoBruce.model.Rol');
        }
        window.down('form').loadRecord(record);
    },
    
    addRol: function(){
        this.createDialog(null);
    },
    
    editRol: function(){
        var model = this.getViewModel().get('selectRol');
        this.createDialog(model);
    },
    
    onSaveRol: function(btn){
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wrol');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
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
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },
    
    createWindow: function (view) {
        var window = Ext.create(view);
        window.getViewModel().set('recordRol', this.getViewModel().get('selectRol'));
    },
    
    onAccesoRol: function(){
        this.createWindow('GrupoBruce.view.acceso.Acceso');
    }
    
});
