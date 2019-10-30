Ext.define('GrupoBruce.view.proforma.FormProforma', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformproforma',
    reference: 'form_proforma',
    id: 'id_wformproforma',

    controller: 'Cproforma',
    viewModel: {
        type: 'VMproforma'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar proforma cliente',
    items: [{
            xtype: 'form',
            items: [{
                    xtype: 'tab',
                    items: [{
                            title: 'General'
                        }, {
                            title: 'Especificaciones'
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
                        click: 'onSaveCliente'
                    }
                }]
        }]
});