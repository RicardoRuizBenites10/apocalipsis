Ext.define('GrupoBruce.view.vacacion.FormVacacionTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'windget.WformVacacionTrabajador',
    reference: 'form_vacacionTrabajador',

    height: 500,
    resizable: false,
    closable: false,
    modal: true,

    items: [{
            xtype: 'form',
            items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Inicio'
                }]
        }]

});