Ext.define('GrupoBruce.view.turno.FormTurno', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformTurno',
    reference: 'form_turno',

    modal: true,
    closable: false,
    width: 400,

    title: 'Editar turno',
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
                            name: 'actual',
                            boxLabel: 'Actualmente seleccionado',
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
                        click: 'onSaveTurno'
                    }
                }]
        }]

});