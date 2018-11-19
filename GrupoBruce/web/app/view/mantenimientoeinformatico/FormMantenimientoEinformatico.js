Ext.define('GrupoBruce.view.mantenimientoeinformatico.FormMantenimientoEinformatico', {
    extend: 'Ext.window.Window',
    alias: 'widget,WformMantenimientoEinformatico',
    reference: 'form_mantenimientoEinformatico',

    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    allowBlank: false
                }
            },
            items: [{
                    items: [{
                            xtype: 'datefield',
                            fieldLabel: 'Fecha programada'
                        }]
                }]
        }]
});