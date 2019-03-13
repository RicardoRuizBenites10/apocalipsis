Ext.define('GrupoBruce.view.pplanilla.PplanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMpplanilla',

    data: {
        selectTipoTrabajador: null,
        selectPeriodoPlanilla: null
    },

    stores: {
        tipostrabajador: {
            type: 'StipoTrabajador',
            autoLoad: true
        },
        conceptos: {
            type: 'Sconcepto',
            autoLoad: true,
            filters: [{
                    property: 'ID_TTRABAJADOR',
                    operator: 'EQ',
                    value: '{selectTipoTrabajador.idTtrabajador}'
                }]
        },
        periodosPlanilla: {
            type: 'SperiodoPlanilla',
            autoLoad: true,
            filters: [{
                    property: 'idTtrabajador',
                    operator: 'EQ',
                    value: '{selectTipoTrabajador.idTtrabajador}'
                }]
        },
        planillasTareo: {
            type: 'SplanillaTareo',
            autoLoad: true,
            loading: true,
            filters: [{
                    property: 'PT.ID_PPLANILLA',
                    operator: 'EQ',
                    value: '{selectPeriodoPlanilla.idPplanilla}'
                }]
        }
    },

    formulas: {
        allRecord: function (get) {
//            var planillas = get('planillasTareo');
//            console.log('raro: ' + planillas.pageSize + '-' + planillas.totalCount);
            return get('selectPeriodoPlanilla');
        }
    }

});
