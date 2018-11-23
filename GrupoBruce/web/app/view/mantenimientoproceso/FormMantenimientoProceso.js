Ext.define('GrupoBruce.view.mantenimientoproceso.FormMantenimientoProceso', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformMantenimientoProceso',
    reference: 'form_mantenimientoProceso',

    modal: true,
    resizable: false,
    closable: false,
    width: 400,

    defaults: {
        layout: 'hbox',
        defaults: {
            allowBlank: false,
            labelAlign: 'top',
            padding: 7
        }
    },

    items: [{
            type: 'datefield',
            name: 'fecha',
            fieldLabel: 'Fecha'
        },{
            type: 'textarea',
            name: 'observacion',
            fieldLabel: 'Observación'
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
                click: 'onSaveMantenimientoProceso'
            }
        }]
});