Ext.define('GrupoBruce.view.regimenpensionario.FormRegimenPensionario', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformRegimenPensionario',
    reference: 'form_regimenPensionario',

    controller: 'Cregimenpensionario',
    viewModel: {
        type: 'VMregimenpensionario'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar regimen pensionario',
    items: [{
            xtype: 'form',
            defaults: {
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
                            name: 'idRpensionario',
                            fieldLabel: 'Código'
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'descripcion',
                            fieldLabel: 'Descripción',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            reference: 'chk_cuspp',
                            name: 'cuspp',
                            fieldLabel: 'Maneja CUSPP',
                            boxLabel: 'Si',
                            flex: 1
                        },{
                            xtype: 'checkbox',
                            reference: 'chk_comision',
                            name: 'comision',
                            fieldLabel: 'Maneja comisión',
                            boxLabel: 'Si',
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
                        click: 'onSaveRegimenPensionario'
                    }
                }]
        }]
});