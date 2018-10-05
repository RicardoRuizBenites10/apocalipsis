Ext.define('GrupoBruce.view.contrato.ContratoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcontratoTrabajador',
    
    data: {
        recordTrabajador: null,
        dada: 1525
    },

    stores: {
        contratos: {
            type: 'ScontratoTrabajador', 
            autoLoad: true,
            filters: [{
                property: 'idTrabajador',
                value: '{recordTrabajador.idTrabajador}'
            }]
        }
    },
    
    formulas: {
        thisTrabajador: function(get){
            return get('recordTrabajador').idTrabajador;
        }
    }

});
