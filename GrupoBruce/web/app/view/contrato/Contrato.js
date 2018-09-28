Ext.define('GrupoBruce.view.contrato.Contrato', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.contrato.ContratoController',
        'GrupoBruce.view.contrato.ContratoModel'
    ],

    controller: 'contrato-contrato',
    viewModel: {
        type: 'contrato-contrato'
    },

    height: 400,
    width: 600,
    resizable: false,
    modal: true,
    closable: true,

    items: [{
            xtype: 'grid',
            reference: 'list_contrato',
            
            bind: {
                store: '{ScontratoTrabajador}'
            },
            style: 'border: solid rgb(234,234,236) 1px',
            columns: [{
                    text: 'Fecha Inicio',
                    dataIndex: 'fechaInicio',
                    flex: 1
                }, {
                    text: 'Fecha fin',
                    dataIndex: 'fechaFin',
                    flex: 1
                }, {
                    text: 'Tipo contrato',
                    flex: 1
                }, {
                    text: 'Estado contrato',
                    flex: 1
                }]
        }],

    tbar: {
        items: [{
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});
