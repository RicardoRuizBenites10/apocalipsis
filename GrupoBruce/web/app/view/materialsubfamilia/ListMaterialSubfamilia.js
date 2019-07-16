Ext.define('GrupoBruce.view.materialsubfamilia.ListMaterialSubfamilia',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistmaterialsubfamilia',
    reference: 'list_materialsubfamilia',
    id: 'id_wlistmaterialsubfamilia',
    
    bind: {
        store: '{materialssubfamilia}',
        selection: '{selectMaterialSubfamilia}'
    },
    allowDeselect: true,
    
    columns: [{
            text: 'Descripción',
            dataIndex: 'descripcion',
            align: 'left',
            width: 200
    },{
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
                    xtype: 'combobox',
                    name: 'idFamilia',
                    displayField: 'descripcion',
                    valueField: 'idFamilia',
                    bind: {
                        store: '{materialsfamilia}',
                        selection: '{selectFamilia}',
                        value: '{recordMaterialFamilia.idFamilia}'
                    },
                    forceSelection: true,
                    editable: false,
                    hideTrigger: true,
                    width: 150
            },{
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectMaterialSubfamilia}'
                    },
                    handler: 'addMaterialSubfamilia'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectMaterialSubfamilia}'
                    },
                    handler: 'editMaterialSubfamilia'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectMaterialSubfamilia}'
                    },
                    handler: 'deleteMaterialSubfamilia'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{materialssubfamilia}'
            },
            displayInfo: true
        }]
});