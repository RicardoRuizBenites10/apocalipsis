Ext.define('GrupoBruce.view.tipotrabajador.ListTipoTrabajador', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistTipoTrabajador',
    reference: 'list_tipoTrabajador',

    bind: {
        store: '{tiposTrabajador}',
        selection: '{selectTipoTrabajador}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idTtrabajador',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'descripcion',
            width: 200,
            align: 'left'
        }, {
            text: 'R. pensionario',
            dataIndex: 'hasrpensionario',
            renderer: function (val) {
                return val ? 'SI' : 'NO';
            },
            width: 150,
            align: 'center'
        }, {
            text: 'Cta. CTS',
            dataIndex: 'hasctacts',
            renderer: function (val) {
                return val ? 'SI' : 'NO';
            },
            width: 150,
            align: 'center'
        }, {
            text: 'Pension',
            dataIndex: 'pension'
        }, {
            text: 'Essalud',
            dataIndex: 'essalud'
        }, {
            text: 'Vida',
            dataIndex: 'vida'
        },{
            text: 'Situación',
            dataIndex: 'situacion',
            width: 150,
            align: 'center',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            }
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectTipoTrabajador}'
                },
                handler: 'addTipoTrabajador'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectTipoTrabajador}'
                },
                handler: 'editTipoTrabajador'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectTipoTrabajador}'
                },
                handler: 'deleteTipoTrabajador'
            },'-',{
                iconCls: 'x-fa fa-calendar-o',
                disabled: true,
                text: 'Periodo planilla',
                bind: {
                    disabled: '{!selectTipoTrabajador}'
                },
                handler: 'onPPlanillaTipoTrabajador'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{tiposTrabajador}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});