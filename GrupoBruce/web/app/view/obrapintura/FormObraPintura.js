Ext.define('GrupoBruce.view.obrapintura.FormObraPintura', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformobrapintura',
    reference: 'form_obrapintura',
    id: 'id_wformobrapintura',

    controller: 'Cobrapintura',
    viewModel: {
        type: 'VMobrapintura'
    },

    modal: true,
    autoShow: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar pintura de OP',
    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    padding: 7,
                    labelAlign: 'top',
                    flex: 1
                }
            },
            items: [{
                    items: [{
                            xtype: 'combobox',
                            name: 'idCdiseno',
                            fieldLabel: 'Color de diseño',
                            valueField: 'idCdiseno',
                            displayField: 'denominacion',
                            bind: {
                                store: '{colordisenos}',
                                selection: '{selectColorDiseno}'
                            },
                            emptyText: 'Seleccionar',
                            forceSelection: true,
                            hideTrigger: true,
                            triggerAction: 'query',
                            pageSize: true,
                            minChars: 3
                            
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
                        click: 'onSaveObraPintura'
                    }
                }]
        }]
});