Ext.define('GrupoBruce.view.requerimiento.ListRequerimiento', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wlistrequerimiento',
    reference: 'list_requerimiento',
    id: 'id_wlistrequerimiento',

    controller: 'Crequerimiento',
    viewModel: {
        type: 'VMrequerimiento'
    },

    modal: true,
    closable: true,
    resizable: false,
    autoShow: true,

    width: 600,

    title: 'Requerimiento',
    items: [{
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    padding: 7
                }
            },
            items: [{
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'OP'
                        }, {
                            xtype: 'combo',
                            fieldLabel: 'Área'
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            fieldLabel: 'Trabajador',
                            hideTrigger: true,
                            width: 356
                        }, {
                            xtype: 'datefield',
                            fieldLabel: 'Programación'
                        }]
                }]
        },{
            
        }]
});