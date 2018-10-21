Ext.define('GrupoBruce.view.formacion.ListFormacion', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistFormacion',
    reference: 'list_formacion',

    bind: {
        store: '{formacions}',
        selection: '{selectFormacion}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Tipo',
            dataIndex: 'idTestudio',
            renderer: function(val){
                switch (val){
                    case 1: return 'Primaria';
                    case 2: return 'Secundaria';
                    case 3: return 'Técnico';
                    case 4: return 'Universitario';
                }
            },
            align: 'left'
        }, {
            text: 'Descripción',
            dataIndex: 'descripcion',
            flex: 2,
            align: 'left'
        }, {
            text: 'Institución',
            dataIndex: 'institucion',
            flex: 2,
            align: 'left'
        }, {
            text: 'Estado',
            dataIndex: 'idEestudio',
            renderer: function(val){
                switch (val){
                    case 1: return 'Completa';
                    case 2: return 'En curso';
                    case 3: return 'Incompleta';
                }
            },
            align: 'left'
        }],
    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectFormacion}'
                },
                handler: 'addFormacion'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectFormacion}'
                },
                handler: 'editFormacion'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectFormacion}'
                },
                handler: 'deleteFormacion'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{formacions}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});
