Ext.define('GrupoBruce.view.asistencia.ListMarcas', {
    extend: 'Ext.window.Window',
    alias: 'widget.WlistMarcas',
    reference: 'list_marcas',

    controller: 'Casistencia',
    viewModel: {
        type: 'VMasistencia'
    },

    autoShow: true,
    modal: true,
    closable: true,
    rezisable: false,
    width: 650,
    height: 500,
    title: 'Registrar marcas',

    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 5
                }
            },
            items: [{
                    items: [{
                            xtype: 'filefield',
                            emptyText: 'Seleccionar archivo',
                            fieldLabel: 'Archivo excel',
                            accept: ".xlsx",
                            buttonConfig: {
                                text: '',
                                iconCls: 'fa fa-file-excel-o'
                            },
                            flex: 1
                        }]
                }],
            buttons: [{
                    text: 'Importar marcaciones',
                    iconCls: 'fa fa-save',
                    formBind: true,
                    listeners: {
                        click: 'onImportacionFile'
                    }
                }]

        }, {
            xtype: 'grid',
            title: 'Lista de marcas de trabajadores',
            collapsible: true,
            bind: {
                store: '{importacions}'
            },
            height: 337,
            style: 'border: solid rgb(234,234,236) 1px',
            columns: [{
                    text: 'idAsistencia',
                    dataIndex: 'idAsistencia',
                    flex: 1,
                    align: 'left'
                },{
                    text: 'Dni',
                    dataIndex: 'idTrabajador',
                    flex: 1,
                    renderer: function(val){
                        console.log("idTrabajador" + val);
                    },
                    align: 'left'
                }, {
                    text: 'Trabajador',
                    dataIndex: 'tarabajador',
                    flex: 2,
                    align: 'left'
                }, {
                    text: 'Fecha',
                    dataIndex: 'fecha',
                    flex: 1,
                    align: 'left'
                }, {
                    text: 'Hora',
                    dataIndex: 'hmarca',
                    align: 'center'
                }],

            tbar: {
                items: [{
                        xtype: 'button',
                        iconCls: 'x-fa fa-save',
                        text: 'Guardar indormación',
                        disabled: true,
                        bind: {
                            disabled: '{selectCargo}'
                        },
                        handler: 'addCargo'
                    }]
            },

            dockedItems: [{
                    xtype: 'pagingtoolbar',
                    dock: 'bottom',
                    bind: {
                        store: '{importacions}'
                    },
                    displayInfo: true,
                    displayMsg: 'Mostrando registros {0} - {1} de {2}',
                    emptyMsg: "No hay registros que mostrar"
                }]
        }]
});