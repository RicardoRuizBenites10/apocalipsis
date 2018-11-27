Ext.define('GrupoBruce.view.asignaciondetalle.FormAsignacionDetalle', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformAsignacionDetalle',
    reference: 'form_asignacionDetalle',

    modal: true,
    autoShow: true,
    resizable: false,
    closable: false,
    width: 400,
    
    controller: 'Casignaciondetalle',
    viewModel: {
        type: 'VMasignaciondetalle'
    },
    
    title: 'Editar asignación de equipo',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    allowBlank: false,
                    padding: 5
                }
            },
            items: [{
                    items: [{
                            xtype: 'datefield',
                            name: 'fechaAsignado',
                            fieldLabel: 'Fecha asignado',
                            format: 'd/m/Y',
                            flex: 1
                    }]
            },{
                    items: [{
                            xtype: 'combobox',
                            id: 'id_equipo',
                            name: 'idEinformatico',
                            valueField: 'idEinformatico',
                            displayField: 'denominacion',
                            fieldLabel: 'Equipo informático',
                            emptyText: 'Buscar..',
                            bind: {
                                store: '{equiposInformatico}',
                                selection: '{selectEquipo}'
                            },
                            tpl: [
                                '<ul class="x-list-plain">',
                                '<tpl for=".">',
                                '<li class="', Ext.baseCSSPrefix, 'grid-group-hd ', Ext.baseCSSPrefix, 'grid-group-title">' +
                                    'Serie : {idEinformatico}' +
                                '</li>',
                                '<li class="x-boundlist-item">',
                                '{denominacion} ',
                                '</li>',
                                '</tpl>',
                                '</ul>'
                            ],
                            minChars: 3,
                            pageSize: true,
                            hideTrigger: true,
                            triggerAction: 'query',
                            flex: 1
                        }]
                }],
            buttons: [{
                    text: 'Cancelar',
                    listeners: {
                        click: function () {
                            this.up('form').reset();
                            this.up('window').close();
                        }
                    }
                }, {
                    text: 'Restablecer',
                    listeners: {
                        click: function () {
                            this.up('form').reset();
                        }
                    }
                }, {
                    text: 'Grabar',
                    iconCls: 'fa fa-save',
                    formBind: true,
                    listeners: {
                        click: 'onSaveAsignacionDetalle'
                    }
                }]
        }]
});