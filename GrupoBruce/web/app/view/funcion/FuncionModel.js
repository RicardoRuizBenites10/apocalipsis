Ext.define('GrupoBruce.view.funcion.FuncionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMfuncion',
    data: {
        title: 'Lista de functiones',
        recordCargo: null,
        selectFuncion: null
    },

    stores: {
        funcions: {
            type: 'Sfuncion',
            autoLoad: true,
            filters: [{
                    property: 'idArea',
                    value: '{recordCargo.idArea}'
                }, {
                    property: 'idCargo',
                    value: '{recordCargo.idCargo}'
                }]
        }
    }

});
