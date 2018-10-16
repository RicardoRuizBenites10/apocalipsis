Ext.define('GrupoBruce.view.periodovacacion.PeriodoVacacionController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.CperiodoVacacion',
    
    addPVacacion: function(){
        var window = new GrupoBruce.view.periodovacacion.FormPeriodoVacacion();
        window.setTitle('Registrar PeriodoVacacion');
    }
});
