Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    onItemSelected: function (sender, record, item, index) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
//        Ext.Msg.alert("Test select", "Row: " + Ext.encode(record.getData()));
//        Ext.Msg.alert("Prueba","Mis datos: " + record.getData().persona.dni);
    },

    nuevoTrabajador: function () {
        var grid = this.lookup('list_trabajador');
        
        var record = grid.getStore().getSelect();
        if(grid){
            Ext.Msg.alert("Test select", "Row: " + Ext.encode(record.getData()));
        }
        
        
    },

    editarTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Editar trabajador.');
    },

    verTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Ver trabajador.');
    }

});
