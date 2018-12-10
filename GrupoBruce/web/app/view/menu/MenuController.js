Ext.define('GrupoBruce.view.menu.MenuController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmenu',
    
    addMenu: function(){
        
    },
    
    editMenu: function(){
        var model = this.getViewModel().get('selectMenu');
        var window = new GrupoBruce.view.menu.FormMenu();
        window.setTitle('Editar menú');
        window.down('form').loadRecord(model);
    },
    
    onSaveMenu: function(btn){
        var window = btn.up('window');
        var form = btn.up('form');
        var model = form.getRecord();
        var grid = Ext.getCmp('id_lmenu');
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (area, operation) {
                    form.reset();
                    window.destroy();
                    grid.getStore().reload();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                },
                failure: function (area, operation) {
                    Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.');
        }
    }
});
