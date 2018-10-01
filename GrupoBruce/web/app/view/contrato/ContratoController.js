Ext.define('GrupoBruce.view.contrato.ContratoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.CcontratoTrabajador',

    addContrato: function () {

        var dada = this.lookupReference('id_trabajador');
        Ext.Msg.alert('Totle', 'Dada: ' + dada.value);
    }

});
