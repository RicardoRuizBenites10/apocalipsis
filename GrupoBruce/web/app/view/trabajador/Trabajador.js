
Ext.define('GrupoBruce.view.trabajador.Trabajador',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.trabajador.TrabajadorController',
        'GrupoBruce.view.trabajador.TrabajadorModel'
    ],

    controller: 'trabajador-trabajador',
    viewModel: {
        type: 'trabajador-trabajador'
    },

    html: 'Hello, World!!'
});
