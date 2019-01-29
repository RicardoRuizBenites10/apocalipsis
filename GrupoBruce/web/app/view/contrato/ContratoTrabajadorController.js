Ext.define('GrupoBruce.view.contrato.ContratoTrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.CcontratoTrabajador',

    createDialog: function (record, inicio) {
        var window = new GrupoBruce.view.contrato.FormContratoTrabajador();
        window.getViewModel().set('currentDate', inicio);
        if (!record) {
            window.setTitle('Registrar contrato');
            var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
            var record = Ext.create('GrupoBruce.model.ContratoTrabajador', {
                idTrabajador: idTrabajador
            });
        }
        window.down('form').loadRecord(record);
    },

    addContrato: function () {
        var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
        Ext.Ajax.request({
            url: 'validaRContrato',
            jsonData: {"idTrabajador": idTrabajador},
            method: 'POST',
            scope: this,
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                var fechaInicio = responseText.inicio !== null ? Ext.Date.add(new Date(responseText.inicio), Ext.Date.DAY, 2) : new Date();
                if (responseText.success) {
                    this.createDialog(null, fechaInicio);
                } else {
                    Ext.Msg.show({
                        title: 'Error',
                        msg: "No se puede registrar nuevo contrato",
                        icon: Ext.Msg.ERROR,
                        botones: Ext.Msg.OK
                    });
                }
            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status', response.status);
            }
        });
    },

    editContrato: function () {
        var grid = this.lookupReference('list_contratoTrabajador');
        var model = grid.getSelection()[0];
        this.createDialog(model, model.get('fechaInicio'));
    },
    
    endContrato: function(){
        var grid = this.lookupReference('list_contratoTrabajador');
        var model = grid.getSelection()[0];
        
        var window = new GrupoBruce.view.contrato.FormContratoFinalizar();
        window.down('form').loadRecord(model);
        
    },
    
    onSaveContrato: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wcontratotrabajador');
        var contratoModel = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(contratoModel); // update the record with the form data
            contratoModel.save({// save the record to the server
                success: function (contrato, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (contrato, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    onFinalizaContrato: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wcontratotrabajador');
        var contratoModel = form.getRecord();
        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(contratoModel); // update the record with the form data
            Ext.Ajax.request({
                url: 'endContrato',
                jsonData: contratoModel.data,
                method: 'POST',
                scope: this,
                success: function (response, opts) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
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
