Ext.define('GrupoBruce.view.regimenpensionario.ListRegimenPensionario', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistRegimenPensionario',
    reference: 'list_regimenPensionario',

    bind: {
        store: '{regimensPensionario}',
        selection: '{selectRegimenPensionario}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idRpensionario',
            align: 'center'
        }, {
            text: 'Descripción',
            dataIndex: 'descripcion',
            width: 200,
            align: 'left'
        },{
            text: 'Tiene CUSPP',
            dataIndex: 'cuspp',
            renderer: function(val){
                return val ? 'SI' : 'NO';
            },
            align: 'center'
        },{
            text: 'Tiene comisiones',
            dataIndex: 'comision',
            renderer: function(val){
                return val ? 'SI' : 'NO';
            },
            align: 'center'
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

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectRegimenPensionario}'
                },
                handler: 'addRegimenPensionario'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectRegimenPensionario}'
                },
                handler: 'editRegimenPensionario'
            }, '-', {
                iconCls: 'x-fa fa-circle',
                disabled: true,
                text: 'Comisión',
                bind: {
                    disabled: '{!selectRegimenPensionario.comision}'
                },
                handler: 'onComisionesRegimenPensionario'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{regimensPensionario}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});

