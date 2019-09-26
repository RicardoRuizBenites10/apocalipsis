Ext.define('GrupoBruce.view.especificacion.FormEspecificacion', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformespecificacion',
    reference: 'form_especificacion',
    id: 'id_wformespecificacion',
    
    controller: 'Cespecificacion',
    viewModel: {
        type: 'VMespecificacion'
    },

    dialog: true,
    closable: false,
    autoShow: true,
    width: 500,
    title: 'Editar Especificación',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 10
                }
            },
            items: [{
                    items: [{
                            xtype: 'textarea',
                            fieldLabel: 'Nombre',
                            name: 'descripcion',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'combobox',
                            reference: 'chk_situacionespecificacion',
                            fieldLabel: 'Situación',
                            comboLabel: 'Activo'
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
                        click: 'onSaveEspecificacion'
                    }
                }]
        }]
});