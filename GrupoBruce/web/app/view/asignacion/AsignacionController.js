Ext.define('GrupoBruce.view.asignacion.AsignacionController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casignacion',
    
    createDialog: function(record){
        var window = new GrupoBruce.view.asignacion.FormAsignacion();
        if(!record){
            window.setTitle('Registrar asignación');
            record = new GrupoBruce.model.AsignacionEquipo();
        }
        window.down('form').loadRecord(record);
    },
    
    addAsignacion: function(){
        this.createDialog(null);
    }
    
});
