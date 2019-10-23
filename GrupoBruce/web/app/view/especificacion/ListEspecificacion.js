Ext.define('GrupoBruce.view.especificacion.ListEspecificacion', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistespecificacion',
    reference: 'list_especificacion',
    id: 'id_wlistespecificacion',

    bind: {
        store: '{especificacions}',
        selection: '{selectEspecificacion}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Nombre',
            dataIndex: 'descripcion',
            align: 'left',
            width: 350
        }, {
            text: 'Categoría',
            dataIndex: 'categoria',
            align: 'left',
            width: 150
        }, {
            text: 'Situacion',
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
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectEspecificacion}'
                    },
                    handler: 'addEspecificacion'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectEspecificacion}'
                    },
                    handler: 'editEspecificacion'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectEspecificacion}'
                    },
                    handler: 'deleteEspecificacion'
                }]
        }]

});