Ext.define('GrupoBruce.view.etapaproceso.ListEtapaProceso', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistetapaproceso',
    reference: 'list_etapaproceso',
    id: 'id_wetapaproceso',

    bind: {
        store: '{etapasproceso}',
        selection: '{selectEtapaProceso}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Descripción',
            dataIndex: 'descripcion'
        }, {
            text: 'Orden',
            dataIndex: 'orden'
        }, {
            text: 'Situación',
            dataIndex: 'situacion',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            },
            align: 'center'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectEtapaProceso}'
                    },
                    handler: 'addEtapaProceso'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectEtapaProceso}'
                    },
                    handler: 'editEtapaProceso'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectEtapaProceso}'
                    },
                    handler: 'deleteEtapaProceso'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{etapasproceso}'
            },
            displayInfo: true
        }]
});