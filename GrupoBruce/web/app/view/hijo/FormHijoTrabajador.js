Ext.define('GrupoBruce.view.hijo.FormHijoTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformHijoTrabajador',

    bind: {
        title: '{title}'
    },
    width: 550,
    resizable: false,
    closable: false,
    modal: true,

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
                    xtype: 'textfield',
                    fieldLabel: 'DNI : '
                }, {
                    xtype: 'datefield',
                    fieldLabel: 'Nacimiento : '
                }, {
                    xtype: 'combo',
                    fieldLabel: 'Genero : ',
                    editable: false,
                    emptyText: 'Seleccionar',
                    displayField: 'descripcion',
                    valueField: 'idGenero',
                    bind: {
                        store: 'generos'
                    }
                }, {
                    xtype: 'textfield',
                    fieldLabel: 'Apellidos y nombres : '
                }]
        }]
});