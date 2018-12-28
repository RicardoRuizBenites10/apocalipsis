Ext.define('GrupoBruce.view.usuario.ListUsuario', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistUsuario',
    reference: 'list_usuario',

    title: 'Lista de usuarios',

    bind: {
        store: '{usuarios}',
        selection: '{selectUsuario}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Trabajador',
            dataIndex: 'trabajador',
            sortable: false,
            align: 'left',
            width: 350
        },
        {
            text: 'Usuario',
            dataIndex: 'usu',
            align: 'left',
            width: 130
        }, {
            text: 'Contraseña',
            dataIndex: 'clave',
            align: 'left',
            width: 200
        }, {
            text: 'Rol',
            dataIndex: 'rol',
            sortable: false,
            align: 'left',
            width: 300
        },{
            text: 'Estado',
            dataIndex: 'estado',
            width: 120,
            align: 'center',
            renderer: function(val){
                if(val){
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                }else{
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            }
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    text: 'Nuevo',
                    iconCls: 'x-fa fa-plus',
                    bind: {
                        disabled: '{selectUsuario}'
                    },
                    listeners: {
                        click: 'addTrabajador'
                    }
                }, {
                    text: 'Editar',
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    bind: {
                        disabled: '{!selectUsuario}'
                    },
                    listeners: {
                        click: 'editTrabajador'
                    }
                }, {
                    text: 'Ver',
                    iconCls: 'x-fa fa-search',
                    disabled: true,
                    bind: {
                        disabled: '{!selectUsuario}'
                    }
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar",
            items: ['-', {
                    iconCls: 'fa fa-file-excel-o'
                }],
            overflowHandler: 'scroller'
        }]
});