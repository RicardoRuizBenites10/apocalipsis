Ext.define('GrupoBruce.view.usuario.UsuarioController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cusuario',

    createDialog: function (record) {
        var window = new GrupoBruce.view.usuario.FormUsuario();
        window.getViewModel().set('newItem', !record);
        if (!record) {
            window.setTitle('Registrar usuario');
            record = new GrupoBruce.model.Usuario();
            record.set('idUsuario', '');
        }
        window.down('form').loadRecord(record);
    },

    addTrabajador: function () {
        this.createDialog(null);
    },

    editTrabajador: function () {
        this.createDialog(this.getViewModel().get('selectUsuario'));
    },

    onSaveUsuario: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wusuario');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.set('estado', window.lookupReference('estado_usuario').checked);

            Ext.Ajax.request({
                url: 'validaNUsuario',
                jsonData: model.data,
                method: 'POST',
                scope: this,
                success: function (response, opts) {
                    var responseText = Ext.decode(response.responseText);
                    var temp = responseText.success ? responseText.success : !window.getViewModel().get('newItem');
                    if (temp) {
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
                    } else {
                        Ext.Msg.show({
                            title: 'Error',
                            msg: "Ya existe un usuario para el trabajador seleccionado, por favor elija otro.",
                            icon: Ext.Msg.ERROR,
                            botones: Ext.Msg.OK
                        });
                    }
                },
                failurer: function (response, opts) {
                    Ext.Msg.alert('Status', response.status);
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }

});
