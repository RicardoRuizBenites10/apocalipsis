Ext.define('GrupoBruce.view.contrato.Contrato', {
    extend: 'Ext.window.Window',
    reference: 'panel_contrato',

    requires: [
        'GrupoBruce.view.contrato.ContratoController',
        'GrupoBruce.view.contrato.ContratoModel'
    ],

    viewModel: {
        type: 'VMcontratoTrabajador'
    },
    controller: 'CcontratoTrabajador',

    height: 400,
    width: 600,
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,

    items: [{
            xtype: 'grid',
            height: 300,
            reference: 'list_contrato',
            bind: {
                store: '{contratos}'
            },
            style: 'border: solid rgb(234,234,236) 1px',
            columns: [{
                    text: 'Fecha Inicio',
                    dataIndex: 'fechaInicio',
                    formatter: 'date("m/d/Y")',
                    sortable: false,
                    flex: 1
                }, {
                    text: 'Fecha Fin',
                    dataIndex: 'fechaFin',
                    formatter: 'date("m/d/Y")',
                    sortable: false,
                    flex: 1
                },{
                    text: 'Tiempo',
                    dataIndex: 'idTiempo',
                    sortable: false,
                    flex: 1,
                    renderer: function (val) {
                        switch (val) {
                            case 1:
                                return 'INDEFINIDO';
                            case 2:
                                return '1 MES';
                            case 3:
                                return '2 MESES';
                            case 4:
                                return '3 MESES';
                            case 5:
                                return '6 MESES';
                            case 6:
                                return '7 MESES';
                            case 7:
                                return '12 MESES';
                        }
                    },
                    align: 'left'
                }, {
                    text: 'Tipo',
                    dataIndex: 'idTcontrato',
                    sortable: false,
                    flex: 2,
                    renderer: function (val) {
                        switch (val) {
                            case '00':
                                return 'CONVENIO';
                            case '01':
                                return 'INDETERMINADO';
                            case '03':
                                return 'INCREMENTO DE ACTIVIDAD';
                            case '04':
                                return 'NECESIDAD DE MERCADO';
                        }
                    },
                    align: 'left'
                }, {
                    text: 'Estado',
                    dataIndex: 'idEcontrato',
                    sortable: false,
                    flex: 1,
                    renderer: function (val) {
                        switch (val) {
                            case 1:
                                return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> VIGENTE </span>';
                            case 2:
                                return '<span style="background:#52AFE1;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> RENOVADO </span>';
                            case 3:
                                return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> TERMINADO </span>';
                            case 4:
                                return '<span style="background:#FFC300;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> CANCELADO </span>';
                        }
                    },
                    align: 'left'
                }]
        }],

    tbar: {
        items: [{
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                handler: 'addContrato'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{contratos}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});
