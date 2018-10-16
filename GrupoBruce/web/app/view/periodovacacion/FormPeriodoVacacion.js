Ext.define('GrupoBruce.view.periodovacacion.FormPeriodoVacacion', {
    extend: 'Ext.window.Window',
    alias: 'widget:WformPeriodoVacacion',
    reference: 'form_periodoVacacion',

    width: 350,
    autoShow: true,
    modal: true,

    items: [{
            xtype: 'form',
            items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Año'
                }, {
                    xtype: 'datefield',
                    fieldLabel: 'Limite superior'
                }, {
                    xtype: 'datefield',
                    fieldLabel: 'Limite inferior'
                }]
        }]
});