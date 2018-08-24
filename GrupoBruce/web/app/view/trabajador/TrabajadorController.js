Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    onItemSelected: function (sender, record, item, index) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
        Ext.Msg.alert("Test select", record.getData());
//        Ext.Msg.alert("Prueba", Ext.encode(record.getData().persona));
    },

    nuevoTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Nuevo trabajador.');
    },

    editarTrabajador: function () {
        var grid = this.lookupReference('gridTrabajador');
        var record = grid.getSelection()[0];
        
        var formT = new GrupoBruce.view.trabajador.TrabajadorForm();
        formT.loadRecord(record);
        var formP = new GrupoBruce.view.trabajador.PersonaForm();
        formP.loadRecord(record.persona);
        
        var window = new Ext.window.Window({
            width: 700,
            height: 400,
            title: 'Employee Salaries',
            items: [formT,{
                    xtype:'personaForm'
            }],
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
