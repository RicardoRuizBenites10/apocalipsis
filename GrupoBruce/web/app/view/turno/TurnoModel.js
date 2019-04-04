Ext.define('GrupoBruce.view.turno.TurnoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMturno',
    data: {
        selectTurno: null
    },
    
    stores: {
        turnos: {
            type: 'Sturno',
            autoLoad: true
        }
    }

});
