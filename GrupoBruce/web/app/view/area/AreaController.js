Ext.define('GrupoBruce.view.area.AreaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Carea',
    
    createDialog: function(record){
        var window = new GrupoBruce.view.area.FormArea();
        var vm = this.getViewModel();
        if(!record){
            window.setTitle('Registrar área');
            record = Ext.create('GrupoBruce.model.Area');
            record.set('idSuparea', vm.get('selectArea').get('idArea'));
            record.set('leaf', true);
        }
        window.down('form').loadRecord(record);
    },
    
    addArea: function () {
        this.createDialog(null);
    },

    editArea: function () {
        var model = this.getViewModel().get('selectArea');
        this.createDialog(model);
    },

    deleteArea: function () {
        var grid = this.lookupReference('list_area');
        var model = grid.getSelection()[0];
        if(model.get('leaf')){
            model.erase({
                success: function (model, operation) {
                    grid.getStore().reload();
                    Ext.Msg.alert('Success', 'Eliminación exitosa.');
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'No se pudo eliminar.');
                }
            });
        }else{
            Ext.Msg.alert('Message', 'Área a eliminar no debe contener subarea.');
        }
            
    },

    onSaveArea: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var area = form.getRecord();
        var grid = Ext.getCmp('id_larea');
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(area); // update the record with the form data
            area.save({// save the record to the server
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
    },
    
    createWindow: function (view) {
        var grid = this.lookupReference('list_area');
        var areaModel = grid.getSelection()[0];
        var window = Ext.create(view);
        window.getViewModel().set('recordArea', areaModel);
    },
    
    onCargos: function(){
        this.createWindow('GrupoBruce.view.cargo.Cargo');
    }
    
});
