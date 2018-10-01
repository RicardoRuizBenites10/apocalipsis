Ext.define('GrupoBruce.view.trabajador.Trabajador', {
    extend: 'Ext.panel.Panel',

    xtype: 'trabajadors',

    requires: [
        'GrupoBruce.view.trabajador.TrabajadorController',
        'GrupoBruce.view.trabajador.TrabajadorModel'

        ,'GrupoBruce.view.trabajador.ListTrabajador'
        ,'GrupoBruce.view.trabajador.FormTrabajador'
        
        ,'GrupoBruce.view.contrato.Contrato'
    ],

    controller: 'Ctrabajador',
    viewModel: {
        type: 'VMtrabajador'
    },

    items: [{
            xtype: 'menubar',
            ignoreParentClicks: true,
            items: [{
                    text: 'Mantenimientos',
                    menu: {
                        items: [{
                                text: 'Áreas de funcionales',
                                iconCls: null
                            }, {
                                text: 'Tipos trabajador',
                                iconCls: null
                            }, {
                                text: 'Estados trabajador',
                                iconCls: null
                            }, {
                                text: 'Regimen pensionario',
                                iconCls: null
                            }, {
                                text: 'Entidades bancarias',
                                iconCls: 'x-fa fa-bank'
                            }, {
                                text: 'Afiliación trabajador',
                                iconCls: null
                            }]
                    }
                }, {
                    text: 'Gestión de trabajadores',
                    menu: {
                        items: [{
                                text: 'Trabajadores',
                                iconCls: 'x-fa fa-male',
                                handler: 'onBodyTrabajador'
                            }]
                    }
                }]
        }, {
            bodyPadding: '30 10 0 10',
            reference: 'body_trabajador'
        }]

});
