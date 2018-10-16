Ext.define('GrupoBruce.view.periodovacacion.PeriodoVacacion', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.periodovacacion.PeriodoVacacionController',
        'GrupoBruce.view.periodovacacion.PeriodoVacacionModel'
    ],

    controller: 'CperiodoVacacion',
    viewModel: {
        type: 'VMperiodoVacacion'
    },

    bind: {
        title: '{titulo}'
    },

    items: [{
            xtype: 'grid',
            bind: {
                store: '{periodosVacacion}',
                selection: '{selectPVacacion}'
            },
            columns: [{
                    text: 'Periodo'
                }, {
                    text: 'Inicio'
                }, {
                    text: 'Fin'
                }, {
                    text: 'Situacion'
                }]
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectPVacacion}'
                },
                handler: 'addPVacacion'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectPVacacion}'
                },
                handler: 'editPVacacion'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectPVacacion}'
                },
                handler: 'deletePVacacion'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{periodosVacacion}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});
