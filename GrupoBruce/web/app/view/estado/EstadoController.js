Ext.define('GrupoBruce.view.estado.EstadoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cestado',

    createDialog: function (record) {
        var window = new GrupoBruce.view.estado.FormEstado();
        var entidad = this.getViewModel().get('recordProceso').get('entidad');
        if (!record) {
            window.setTitle('Registrar estado');
            record = Ext.create('GrupoBruce.model.' + entidad);
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addEstado: function () {
        this.createDialog(null);
    },

    editEstado: function () {
        var model = this.getViewModel().get('selectEstado');
        this.createDialog(model);
    }

});
