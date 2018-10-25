Ext.define('GrupoBruce.view.cargo.CargoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcargo',
    data: {
        title: 'Lista de cargos',
        recordArea: null
    },
    
    stores: {
        cargos: {
            type: 'Scargo',
            autoLoad: true,
            filters: [{
                    property: 'idArea',
                    value: '{recordArea.idArea}'
            }]
        }
    }

});
