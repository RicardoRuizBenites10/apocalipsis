Ext.define('GrupoBruce.view.vacacion.VacacionTrabajador', {
    extend: 'Ext.window.Window',
    reference: 'panel_vacacion',

    requires: [
        'GrupoBruce.view.vacacion.VacacionTrabajadorController',
        'GrupoBruce.view.vacacion.VacacionTrabajadorModel',
        
        'GrupoBruce.view.vacacion.ListVacacionTrabajador',
        'GrupoBruce.view.vacacion.FormVacacionTrabajador'
    ],

    viewModel: {
        type: 'VMvacacionTrabajador'
    },
    controller: 'CvacacionTrabajador',
    
    height: 400,
    width: 600,
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,
    
    bind: {
        title: '{title}'
    },
    
    items: [{
            xtype: 'WlistVacacionTrabajador',
            height: 355
        }]
});
