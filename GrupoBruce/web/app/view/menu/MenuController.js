Ext.define('GrupoBruce.view.menu.MenuController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmenu',

    addMenu: function () {
        var rootModel = this.getViewModel().get('selectMenu');
        var childModel = Ext.create('GrupoBruce.model.Menu');
        var window = new GrupoBruce.view.menu.FormMenu();
        window.setTitle('Registrar menú');

        var parentId = 'root';
        if (rootModel) {
            parentId = rootModel.get('idMenu');
        }
        childModel.set('idSupmenu', parentId);
        childModel.set('leaf', true);
        window.down('form').loadRecord(childModel);
    },

    editMenu: function () {
        var model = this.getViewModel().get('selectMenu');
        var window = new GrupoBruce.view.menu.FormMenu();
        window.setTitle('Editar menú');
        window.down('form').loadRecord(model);
    },

    deleteMenu: function () {
        var grid = this.lookupReference('list_menu');
        var model = grid.getSelection()[0];
        if (model.get('leaf')) {
            model.erase({
                success: function (response, operation) {
                    grid.getStore().reload();
                    var main = Ext.getCmp('id_mainMenu').down('treelist');
                    main.getStore().getRoot().removeAll();
                    main.getStore().reload();
                    Ext.Msg.alert('Success', 'Eliminación exitosa.');
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Failure', 'No se pudo eliminar.');
                }
            });
        } else {
            Ext.Msg.alert('Message', 'Menú a eliminar no debe contener submenu(s).');
        }
    },

    onSaveMenu: function (btn) {
        var window = btn.up('window');
        var form = btn.up('form');
        var model = form.getRecord();
        var grid = Ext.getCmp('id_lmenu');
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
                var check = window.lookupReference('check_proceso').checked;
            model.set('proceso', check);
            if(!check){
                model.set('codProceso','');
            }
            model.save({// save the record to the server
                success: function (area, operation) {
                    form.reset();
                    window.destroy();
                    grid.getStore().reload();
                    var main = Ext.getCmp('id_mainMenu').down('treelist');
                    main.getStore().getRoot().removeAll();
                    main.getStore().reload();
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
