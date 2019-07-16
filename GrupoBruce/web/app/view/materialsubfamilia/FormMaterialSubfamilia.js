Ext.define('GrupoBruce.view.materialsubfamilia.FormMaterialSubfamilia', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformmaterialsubfamilia',
    reference: 'form_materialsubfamilia',
    id: 'id_wformmaterialsubfamilia',

    controller: 'Cmaterialsubfamilia',
    viewModel: {
        type: 'VMmaterialsubfamilia'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 350,

    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    padding: 5,
                    labelAlign: 'top'
                }
            },

            items: [{
                    items: [{
                            xtype: 'textfield',
                            name: 'descripcion',
                            fieldLabel: 'Descripción',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'situacion',
                            reference: 'chk_situacionmaterialsubfamilia',
                            fieldLabel: 'Situación',
                            boxLabel: 'Activo'
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
                        click: 'onSaveMaterialSubfamilia'
                    }
                }]
        }]
});