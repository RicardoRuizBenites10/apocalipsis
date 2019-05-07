Ext.define('GrupoBruce.view.chasisproveedor.FormChasisProveedor', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformchasisproveedor',
    reference: 'form_chasisproveedor',
    id: 'id_wformchasisproveedor',

    controller: 'Cchasisproveedor',
    viewModel: 'VMchasisproveedor',

    width: 400,
    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,

    title: 'Editar proveedor chasis',
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
                            name: 'nombre',
                            fieldLabel: 'Nombre',
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
                        click: 'onSaveChasisProveedor'
                    }
                }]
        }]
});