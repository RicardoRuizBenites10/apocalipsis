Ext.define('GrupoBruce.view.trabajador.TrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtrabajador',
    
    data: {
        name: 'GrupoBrucewsss',
        hasrpensionario: false
    },

    stores: {
        trabajadores: {
            type: 'Strabajador'
        }
    }

});
