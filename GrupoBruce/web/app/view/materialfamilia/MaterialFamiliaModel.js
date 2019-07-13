Ext.define('GrupoBruce.view.materialfamilia.MaterialFamiliaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmaterialfamilia',
    
    data: {
        titulo: 'Lista de familias de material'
    },
    
    stores: {
        materialsfamilia: {
            type: 'Smaterialfamilia',
            autoLoad: true
        }
    }

});
