Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    onHeaderClick: function (header, column, event, t, eOpts) {
        // header:Header Container of grid
        // column: The Column header Component
        var store = header.grid.getStore(); //.sorters.filter('property', column.dataIndex);

        store.getProxy().extraParams = {
            sort: 50,
            filter: 'dad'
        };

        store.load();
        Ext.Msg.alert("Prueba", "Datos: " + column.dataIndex + " - " + store.getSorters().filter('property', column.dataIndex) );
    },

    onItemSelected: function (sender, record, item, index) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
        Ext.Msg.alert("Prueba", "Datos: " + Ext.encode(record.getData()));
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
