Ext.define('GrupoBruce.view.menu.MenuModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmenu',
    
    data: {
        title: 'Lista de menus del sistema',
        selectMenu: null
    },
    
    stores: {
        menus: {
            type:'Smenu',
            autoLoad: true
        }
    }

});
