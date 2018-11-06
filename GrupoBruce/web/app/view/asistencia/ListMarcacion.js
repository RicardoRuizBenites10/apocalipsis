Ext.define('GrupoBruce.view.asistencia.ListMarcacion', {
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
    resizable: false,
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
                    text: 'Dni',
                    sortable: false,
                    dataIndex: 'idTrabajador',
                    align: 'left'
                }, {
                    text: 'Trabajador',
                    dataIndex: 'trabajador',
                    sortable: false,
                    flex: 2,
                    align: 'left'
                }, {
                    text: 'Fecha',
                    dataIndex: 'fechaTemp',
                    sortable: false,
                    formatter: 'date("d/m/Y")',
                    flex: 1,
                    align: 'left'
                }, {
                    text: 'Hora',
                    dataIndex: 'hmarca',
                    sortable: false,
                    formatter: 'date("h:i A")',
                    align: 'center'
                }],

            tbar: {
                items: [{
                        xtype: 'button',
                        iconCls: 'x-fa fa-repeat',
                        text: 'Procesar marcas',
                        disabled: true,
                        bind: {
                            disabled: '{importacions.data.length===0}'
                        },
                        handler: 'saveImport'
                    }]
            }
        }]
});