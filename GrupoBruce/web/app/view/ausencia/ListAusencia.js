Ext.define('GrupoBruce.view.ausencia.ListAusencia', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAusencia',
    reference: 'list_ausencia',

    bind: {
        store: '{ausencias}',
        selection: '{selectAusencia}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Tipo ausencia',
            dataIndex: 'idTausencia',
            align: 'left',
            renderer: function (val) {
                switch (val) {
                    case 1:
                        return 'Enfermedad';
                    case 2:
                        return 'Enfermedad de familiar';
                    case 3:
                        return 'Paternidad / Maternidad';
                    case 4:
                        return 'Otros';
                }
            },
            flex: 1
        }, {
            text: 'Tiempo',
            dataIndex: 'idTmausencia',
            width: 80,
            align: 'left',
            renderer: function (val) {
                switch (val) {
                    case 1:
                        return 'Dia(s)';
                    case 2:
                        return 'Horas';
                }
            }
        },{
            text: 'Fecha inicio',
            dataIndex: 'fechaInicio',
            formatter: 'date("d/m/Y")'
        }, {
            text: 'Fecha fin',
            dataIndex: 'fechaFin',
            formatter: 'date("d/m/Y")'
        }, {
            text: 'H.Inicio',
            dataIndex: 'horaInicio',
            formatter: 'date("h:i A")',
            align: 'center'
        }, {
            text: 'H.Fin',
            dataIndex: 'horaFin',
            formatter: 'date("h:i A")',
            align: 'center'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectAusencia}'
                },
                handler: 'addAusencia'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectAusencia}'
                },
                handler: 'editAusencia'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectAusencia}'
                },
                handler: 'deleteAusencia'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{ausencias}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});