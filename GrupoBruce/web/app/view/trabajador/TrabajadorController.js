Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    onItemSelected: function (sender, record, item, index) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
//        Ext.Msg.alert("Test select", "Row: " + Ext.encode(record.getData()));
//        Ext.Msg.alert("Prueba","Mis datos: " + record.getData().persona.dni);
    },

    nuevoTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Nuevo trabajador.');
    },

    editarTrabajador: function () {
        var grid = this.lookupReference('gridTrabajador');
        if (grid) {
            var record = grid.getStore();
            Ext.Msg.alert("Test select", "Row: " + Ext.encode(record.getData()));
        }
    },

    verTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Ver trabajador.');
    }

});
