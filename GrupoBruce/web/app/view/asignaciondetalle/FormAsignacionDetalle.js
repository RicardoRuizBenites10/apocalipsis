Ext.define('GrupoBruce.view.asignaciondetalle.FormAsignacionDetalle', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformAsignacionDetalle',
    reference: 'form_asignacionDetalle',

    modal: true,
    autoShow: true,
    resizable: false,
    closable: false,
    width: 400,
    
    title: 'Editar asignación de equipo',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    allowBlank: false,
                    padding: 5
                }
            },
            items: [{
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Equipo informático',
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
                        click: 'onSaveAsignacionDetalle'
                    }
                }]
        }]
});