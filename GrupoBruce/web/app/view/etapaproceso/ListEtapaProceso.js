Ext.define('GrupoBruce.view.etapaproceso.ListEtapaProceso', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.Wlistetapaproceso',
    reference: 'list_etapaproceso',
    id: 'id_wetapaproceso',

    bind: {
        store: '{etapasproceso}',
        selection: '{selectEtapaProceso}'
    },
    allowDeselect: true,
    rootVisible: false,
    useArrows: true,

    columns: [{
            text: 'Código',
            dataIndex: 'idEproceso'
        }, {
            xtype: 'treecolumn',
            text: 'Descripción',
            dataIndex: 'descripcion',
            width: 300,
            align: 'left'
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