Ext.define('GrupoBruce.view.ausencia.AusenciaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMausencia',
    data: {
        title: 'Lista de contratos',
        recordTrabajador: null,
        selectAusencia: null
    },
    
    stores: {
        ausencias: {
            type: 'Sausencia',
            autoLoad: true,
            filters: [{
                    property: 'idTrabajador',
                    value: '{recordTrabajador.idTrabajador}'
                }]
        },
        tiemposAusencia: {
            type: 'StiempoAusencia',
            autoLoad: true
        },
        tiposAusencia: {
            type: 'StipoAusencia',
            autoLoad: true
        }
    }

});
