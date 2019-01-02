Ext.define('GrupoBruce.view.proceso.ListProceso', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistProceso',
    reference: 'list_proceso',

    bind: {
        store: '{procesos}',
        selection: '{selectProceso}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idProceso',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            width: 400,
            align: 'left'
        },{
            text: 'Entidad a manejar',
            dataIndex: 'entidad',
            align: 'left',
            width: 250
        }, {
            text: 'Estado',
            dataIndex: 'estado',
            width: 150,
            align: 'center',
            renderer: function(val){
                if(val){
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                }else{
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            }
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectProceso}'
                },
                handler: 'addProceso'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectProceso}'
                },
                handler: 'editProceso'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectProceso}'
                },
                handler: 'deleteProceso'
            }, '-', {
                iconCls: 'x-fa fa-retweet',
                disabled: true,
                text: 'Etapas de proceso',
                bind: {
                    disabled: '{!selectProceso}'
                },
                handler: 'onEtapasProceso'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{procesos}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});