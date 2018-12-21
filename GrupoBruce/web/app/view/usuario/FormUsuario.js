Ext.define('GrupoBruce.view.usuario.FormUsuario', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformUsuario',
    reference: 'form_usuario',

    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,
    height: 400,
    width: 600,

    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    fieldAlign: 'top'
                }
            },

            items: [{
                    items: [{
                            xtype: 'textfield',
                            name: 'usu'
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'clave'
                        }, {
                            xtype: 'textfield'
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idRol',
                            fieldLabel: 'Rol',
                            editable: false,
                            emptyText: 'Seleccionar',
                            displayField: 'denominacion',
                            valueField: 'idRol',
                            bind: {
                                store: '{rols}'
                            }
                        }]
                }]
        }]
});