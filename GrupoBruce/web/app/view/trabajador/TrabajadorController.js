Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    onHeaderClick: function (header, column, event, t, eOpts) {
        var store = header.grid.getStore();      
        store.load();
    },

    onItemSelected: function (sender, record, item, index) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
//        Ext.Msg.alert("Test select", "Row: " + Ext.encode(record.getData()));
//        Ext.Msg.alert("Prueba","Mis datos: " + record.getData().persona.dni);
    },

    nuevoTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Nuevo trabajador.');
    },

    editarTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Editar trabajador.');
    },

    verTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Ver trabajador.');
    }

});
