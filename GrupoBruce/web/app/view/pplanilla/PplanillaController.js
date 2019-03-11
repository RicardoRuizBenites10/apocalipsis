Ext.define('GrupoBruce.view.pplanilla.PplanillaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cpplanilla',
    
    onAprobar: function(btn){
        var grid = btn.up('WlistPplanilla');
        var store = grid.getStore();
        store.each(function(item){
            
        });
    }
    
});
