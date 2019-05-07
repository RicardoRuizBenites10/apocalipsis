Ext.define('GrupoBruce.view.carroceriamodelo.ListCarroceriaModelo', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistCarroceriaModel',
    reference: 'list_carroceriamodelo',
    id: 'id_wlistCarroceriaModel',

    bind: {
        store: '{carroceriaModelos}',
        selection: '{selectCarroceriaModelo}'
    },
    allowDeselect: true,

    title: 'Lista de modelos de carrocería',
    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idCarmod',
            align: 'left',
            width: 130
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            align: 'left',
            width: 300
        }, {
            text: 'Situación',
            dataIndex: 'situacion',
            renderer: function(val){
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            },
            align: 'center',
            width: 300
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectCarroceriaModelo}'
                    },
                    handler: 'addCarroceriaModelo'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectCarroceriaModelo}'
                    },
                    handler: 'editCarroceriaModelo'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectCarroceriaModelo}'
                    },
                    handler: 'deleteCarroceriaModelo'
                }, '-', {
                    text: 'Subtipos de carrocería',
                    iconCls: 'x-fa fa-list',
                    disabled: true,
                    bind: {
                        disabled: '{!selectCarroceriaModelo}'
                    },
                    handler: 'onCarroceriaSubtipo'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{asignacions}'
            },
            displayInfo: true
        }]
});