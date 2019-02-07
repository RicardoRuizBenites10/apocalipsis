Ext.define('GrupoBruce.view.tipoplanilla.FormTipoPlanilla', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformTipoPlanilla',
    reference: 'form_tipoPlanilla',

    controller: 'Ctipoplanilla',
    viewModel: 'VMtipoplanilla',

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar tipo planilla',
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
                            name: 'idTipo',
                            fieldLabel: 'Código',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'descripcion',
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
                        click: 'onSaveTipoPlanilla'
                    }
                }]
        }]
});