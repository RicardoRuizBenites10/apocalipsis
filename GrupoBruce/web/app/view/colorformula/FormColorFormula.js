Ext.define('GrupoBruce.view.colorformula.FormColorFormula', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformcolorformula',
    reference: 'form_colorformula',
    id: 'id_wformcolorformula',

    controller: 'Ccolorformula',
    viewModel: {
        type: 'VMcolorformula'
    },

    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,

    width: 400,

    title: 'Editar formula',
    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    padding: 7,
                    allowBlank: false,
                    flex: 1
                }
            },
            items: [{
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Material',
                            name: 'idMaterial',
                            valueField: 'idMaterial',
                            displayField: 'nombre',
                            bind: {
                                store: '{materials}',
                                selection : '{selectColorFormula}'
                            },
                            emptyText: 'Seleccionar',
                            hideTrigger: true,
                            forceSelection: true,
                            minChars: 3,
                            pageSize: true,
                            triggerAction: 'query',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'numberfield',
                            name: 'cantidad',
                            fieldLabel: 'Cantidad en gramos',
                            decimalPrecision: 6,
                            hideTrigger: true
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
                        click: 'onSaveColorFormula'
                    }
                }]
        }]
});