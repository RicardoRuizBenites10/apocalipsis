Ext.define('GrupoBruce.view.equipo.EquipoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cequipo',
    
    createDialog: function(record){
        var window = new GrupoBruce.view.equipo.FormEquipo();
        if(!record){
            window.setTitle('Registrar equipo informatico');
            record = new GrupoBruce.model.EquipoInformatico();
        }
        window.down('form').loadRecord(record);
    },
    
    addEquipo: function(){
        this.createDialog(null);
    }
    
});
