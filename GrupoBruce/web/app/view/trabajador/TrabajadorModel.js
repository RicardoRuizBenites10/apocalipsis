Ext.define('GrupoBruce.view.trabajador.TrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtrabajador',
    
    data: {
        name: 'GrupoBruce'
    },

    stores: {
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true
        }
    },
    
    formulas: {
        hasChild: function(get){
            var select = get('selectTrabajador');
            return select ? select.get('nroHijos') === 0 : true;
        }
    }

});
