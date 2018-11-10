Ext.define('GrupoBruce.view.equipo.EquipoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMequipo',

    data: {
        title: 'Lista de equipos informaticos',
        selectEquipo: null,
        serie: ''
    },

    stores: {
        equiposInformatico: {
            type: 'SequipoInformatico',
            autoLoad: true
        },
        tiposEquipo: {
            type: 'StipoEquipo',
            autoLoad: true,
            filters: [{
                    property: 'situacion',
                    value: true
                }]
        }
    }

});
