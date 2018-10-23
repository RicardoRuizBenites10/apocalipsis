Ext.define('GrupoBruce.view.area.FormArea', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformArea',
    reference: 'form_area',

    bind: {
        title: '{title}'
    },
    modal: true,
    closable: false,
    rezisable: false,
    width: 400,

    items: [{
            xtype: 'form',
            items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Nombre de área funcional'
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
                click: 'onSaveArea'
            }
        }]

});
