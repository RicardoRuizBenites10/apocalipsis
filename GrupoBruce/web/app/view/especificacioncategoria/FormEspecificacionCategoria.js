Ext.define('GrupoBruce.view.especificacioncategoria.FormEspecificacionCategoria', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformespecificacioncategoria',
    reference: 'form_especificacioncategoria',
    id: 'id_formespecificacioncategoria',

    controller: 'Cespecificacioncategoria',
    viewModel: {
        type: 'VMespecificacioncategoria'
    },

    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,
    width: 400,
    title: 'Editar Categoría Especificación',

    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
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
                            name: 'nombre',
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                },{
                    items: [{
                            xtype: 'checkbox',
                            reference: 'chk_situacionespecificacioncategoria',
                            name: 'situacion',
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
                        click: 'onSaveEspecificacionCategoria'
                    }
                }]
        }]
});