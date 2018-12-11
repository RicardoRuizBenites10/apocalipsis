Ext.define('GrupoBruce.view.area.AreaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Carea',
    
    addArea: function () {
        var areaModel = Ext.create('GrupoBruce.model.Area');

        var window = new GrupoBruce.view.area.FormArea();
        window.setTitle('Registrar área');
        var parentId = this.getViewModel().get('selectArea').get('idArea');
        areaModel.set('idSuparea', parentId);
        areaModel.set('leaf', true);
        
        window.down('form').loadRecord(areaModel);
    },

    editArea: function () {
        var model = this.getViewModel().get('selectArea');
        var window = new GrupoBruce.view.area.FormArea();
        window.setTitle('Editar área');
        window.down('form').loadRecord(model);
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
