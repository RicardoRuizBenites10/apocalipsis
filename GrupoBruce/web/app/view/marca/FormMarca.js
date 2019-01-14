Ext.define('GrupoBruce.view.marca.FormMarca', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformMarcacion',
    reference: 'form_marcacion',

    controller: 'Cmarca',
    viewModel: {
        type: 'VMmarca'
    },

    width: 400,
    resizable: false,
    closable: false,
    modal: true,
    autoShow: true,
    title: 'Editar marcación',

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
                            xtype: 'combo',
                            id: 'id_trabajadorMarca',
                            name: 'idTrabajador',
                            valueField: 'idTrabajador',
                            displayField: 'nombres',
                            fieldLabel: 'Trabajador',
                            emptyText: 'Buscar..',
                            bind: {
                                store: '{trabajadors}',
                                selection: '{selectTrabajador}'
                            },
                            tpl: [
                                '<ul class="x-list-plain">',
                                '<tpl for=".">',
                                '<li class="',
                                Ext.baseCSSPrefix, 'grid-group-hd ', Ext.baseCSSPrefix, 'grid-group-title">DNI : {idTrabajador}</li>',
                                '<li class="x-boundlist-item">',
                                '{nombresCompletos} ',
                                '</li>',
                                '</tpl>',
                                '</ul>'
                            ],
                            minChars: 3,
                            editable: false,
                            pageSize: true,
                            hideTrigger: true,
                            triggerAction: 'query',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'fecha',
                            format: 'd/m/Y',
                            editable: false,
                            fieldLabel: 'Fecha'
                        }, {
                            xtype: 'timefield',
                            name: 'hmarca',
                            fieldLabel: 'Hora marcación',
                            minValue: '7:30 am',
                            maxValue: '4:30 pm',
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
                        click: 'onSaveMarcacion'
                    }
                }]
        }]

});