Ext.define('GrupoBruce.view.cargo.ListCargo', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistCargo',
    reference: 'list_cargo',

    bind: {
        store: '{cargos}',
        selection: '{selectCargo}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Nombre de cargo',
            dataIndex: 'nombre',
            flex: 1,
            align: 'left'
        }, {
            text: 'Descripcion',
            dataIndex: 'descripcion',
            flex: 1,
            align: 'left'
        },{
            text: 'Situacion',
            dataIndex: 'situacion',
            renderer: function(val){
                return val ? 'Activo' : 'Desactivo';
            },
            align: 'center'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectCargo}'
                },
                handler: 'addCargo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectCargo}'
                },
                handler: 'editCargo'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectCargo}'
                },
                handler: 'deleteCargo'
            },'-',{
                iconCls: 'x-fa fa-bullseye',
                disabled: true,
                text: 'Funciones',
                bind: {
                    disabled: '{!selectCargo}'
                },
                handler: 'onFunciones'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{cargos}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});
