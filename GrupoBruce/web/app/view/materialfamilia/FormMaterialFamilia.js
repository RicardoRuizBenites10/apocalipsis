Ext.define('GrupoBruce.view.materialfamilia.FormMaterialFamilia', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformmaterialfamilia',
    reference: 'form_materialfamilia',
    id: 'id_wformmaterialfamilia',

    controller: 'Cmaterialfamilia',
    viewModel: {
        type: 'VMmaterialfamilia'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 350,
    title: 'Editar familia material',

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
                            xtype: 'textfield',
                            name: 'descripcion',
                            fieldLabel: 'Descripción',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'situacion',
                            reference: 'chk_situacionmaterialfamilia',
                            fieldLabel: 'Situación',
                            boxLabel: 'Activo',
                            width: '48%'
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
                        click: 'onSaveMaterialFamilia'
                    }
                }]
        }]

});