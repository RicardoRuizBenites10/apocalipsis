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
        var record = grid.getSelection()[0];
        
        var form = new GrupoBruce.view.trabajador.TrabajadorForm();
        form.loadRecord(record);
        var window = new Ext.window.Window({
            width: 700,
            height: 400,
            title: 'Employee Salaries',
            items: form,
            closable: false,
            resizable: false,
            modal: true
        });
        window.show();
    },

    verTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Ver trabajador.');
    }

});
