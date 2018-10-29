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
    width: 600,
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
                            name: 'fileMarca',
                            accept: 'image',
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
                        click: 'uploadFile'
                    }
                }]

        }, {
            xtype: 'grid',
            title: 'Lista de marcas de trabajadores',
            collapsible: true,
            colums: [{
                    text: 'DNI'
                }, {
                    text: 'Trabajador'
                }, {
                    text: 'Fecha/Hora de marcación'
                }]
        }]
});