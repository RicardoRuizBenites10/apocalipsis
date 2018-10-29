Ext.define('GrupoBruce.view.asistencia.AsistenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casistencia',
    
    createDialog: function(){
        var window = new GrupoBruce.view.asistencia.ListMarcas();
    },
    
    onImportacionMarcas: function(){
        this.createDialog();
    }

});
