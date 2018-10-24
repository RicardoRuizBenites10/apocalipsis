Ext.define('GrupoBruce.view.area.AreaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMarea',
    data: {
        title: 'Lista de áreas funcionales',
        selectArea: null
    },
    
    stores: {
        areas: {
            type: 'Sarea',
            autoLoad: true
        }
    }

});
