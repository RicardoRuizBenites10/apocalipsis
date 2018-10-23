Ext.define('GrupoBruce.view.area.AreaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMarea',
    data: {
        title: 'Lista de áreas funcionales'
    },
    
    stores: {
        areas: {
            type: 'Sarea',
            autoLoad: true
        }
    }

});
