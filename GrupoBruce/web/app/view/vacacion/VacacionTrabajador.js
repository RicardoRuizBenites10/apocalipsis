
Ext.define('GrupoBruce.view.vacacion.VacacionTrabajador',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.vacacion.VacacionTrabajadorController',
        'GrupoBruce.view.vacacion.VacacionTrabajadorModel'
    ],

    controller: 'CvacacionTrabajador',
    viewModel: {
        type: 'VMvacacionTrabajador'
    },

    html: 'Hello, World!!'
});
