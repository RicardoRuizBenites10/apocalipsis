Ext.define('GrupoBruce.view.conceptoasignado.ConceptoAsignadoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cconceptoasignado',

    onAsignar: function (btn) {
        var vm = btn.up('window').getViewModel();
        var concepto = vm.get('selectConcepto');
        var planilla = vm.get('selectTipoPlanilla');

        var model = new GrupoBruce.model.ConceptoAsignado();
        model.set('idTtrabajador', concepto.get('idTtrabajador'));
        model.set('idConcepto', concepto.get('idConcepto'));
        model.set('idTplanilla', planilla.get('idTipo'));
        model.set('fecha', new Date());

        model.save({// save the record to the server
            success: function (model, operation) {
                Ext.getCmp('id_wlistconceptoasignado').getStore().reload();
                Ext.Msg.alert('Success', 'Operación exitosa.')
            },
            failure: function (model, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    },

    onDesasignar: function (btn) {
        var vm = btn.up('window').getViewModel();
        var model = vm.get('selectConceptoAsignado');
        model.erase({
            success: function (response, operation) {
                Ext.getCmp('id_wlistconceptoasignado').getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'No se pudo eliminar.');
            }
        });
    }

});
