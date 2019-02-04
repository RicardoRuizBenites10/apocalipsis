Ext.define('GrupoBruce.view.calendario.CalendarioModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcalendario',
    data: {
        name: 'GrupoBruce'
    },
    
    stores: {
        calendarios: {
            type: 'Scalendario',
            autoLoad: true
        }
    }
});
