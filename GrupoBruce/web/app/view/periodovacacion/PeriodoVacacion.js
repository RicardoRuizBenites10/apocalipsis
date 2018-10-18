Ext.define('GrupoBruce.view.periodovacacion.PeriodoVacacion', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.periodovacacion.PeriodoVacacionController',
        'GrupoBruce.view.periodovacacion.PeriodoVacacionModel',

        'GrupoBruce.view.periodovacacion.FormPeriodoVacacion'
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
            reference: 'list_pvacacion',
            id: 'id_lpvacacion',
            bind: {
                store: '{periodosVacacion}',
                selection: '{selectPVacacion}'
            },
            allowDeselect: true,
            columns: [{
                    text: 'Periodo',
                    dataIndex: 'idPVacacion'
                }, {
                    text: 'Inicio',
                    formatter: 'date("d/m/Y")',
                    dataIndex: 'limInicio'
                }, {
                    text: 'Fin',
                    formatter: 'date("d/m/Y")',
                    dataIndex: 'limFin'
                }, {
                    text: 'Situacion',
                    dataIndex: 'cerrado',
                    renderer: function (val) {
                        return val ? 'Cerrado' : 'Abierto';
                    }
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
                text: 'Editar',
                bind: {
                    disabled: '{!selectPVacacion}'
                },
                handler: 'editPVacacion'
            }, {
                iconCls: 'x-fa fa-trash',
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
