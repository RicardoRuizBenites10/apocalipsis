Ext.define('GrupoBruce.view.area.AreaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMarea',
    data: {
        selectArea: null
    },
    
    stores: {
        areas: {
            type: 'Sarea',
            autoLoad: true
        }
    }

});
