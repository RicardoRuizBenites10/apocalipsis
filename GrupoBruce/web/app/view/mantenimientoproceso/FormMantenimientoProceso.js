Ext.define('GrupoBruce.view.mantenimientoproceso.FormMantenimientoProceso', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformMantenimientoProceso',
    reference: 'form_mantenimientoProceso',

    controller: 'Cmantenimientoproceso',
    viewModel: {
        type: 'VMmantenimientoproceso'
    },

    modal: true,
    resizable: false,
    closable: false,
    autoShow: true,
    width: 400,
    
    title: 'Editar Proceso mantenimiento',
    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    padding: 5,
                    allowBlank: false
                }
            },
            items: [{
                    items: [{
                            xtype: 'datefield',
                            name: 'fecha',
                            fieldLabel: 'Fecha',
                            editable: false,
                            format: 'd/m/Y',
                            bind: '{fechaHoy}'
                        }]
                },{
                    items: [{
                            xtype: 'combobox',
                            id: 'id_solucionador',
                            name: 'idSolucionador',
                            valueField: 'idTrabajador',
                            displayField: 'nombres',
                            fieldLabel: 'Brinda solución',
                            emptyText: 'Buscar..',
                            bind: {
                                store: '{trabajadors}',
                                selection: '{selectSolucionador}'
                            },
                            tpl: [
                                '<ul class="x-list-plain">',
                                '<tpl for=".">',
                                '<li class="x-boundlist-item">',
                                '{nombresCompletos} ',
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
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'observacion',
                            fieldLabel: 'Observación',
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
                        click: 'onSaveMantenimientoProceso'
                    }
                }]
        }]

});