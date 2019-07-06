Ext.define('GrupoBruce.view.etapaproceso.ListEtapaProceso',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistetapaproceso',
    reference: 'list_etapaproceso',
    
    bind: {
        store: 'etapasproceso',
        selection: 'selectEtapaProceso'
    },
    allowDeselect: true,
    
    items: [{
            text: 'Descripción',
            dataIndex: 'descripcion'
    },{
        text: 'Orden',
        dataIndex: 'orden'
    }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectEtapaEmpresa}'
                    },
                    handler: 'addEtapaEmpresa'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectEtapaEmpresa}'
                    },
                    handler: 'editEtapaEmpresa'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectEtapaEmpresa}'
                    },
                    handler: 'deleteEtapaEmpresa'
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