Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',
    
    nuevoTrabajador: function(){
        Ext.Msg.alert('Alerta','Nuevo trabajador.');
    },
    
    editarTrabajador: function(){
        Ext.Msg.alert('Alerta','Editar trabajador.');
    },
    
    verTrabajador: function(){
        Ext.Msg.alert('Alerta','Ver trabajador.');
    }
    
});
