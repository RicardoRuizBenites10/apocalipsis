Ext.define('GrupoBruce.view.pplanilla.PplanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMpplanilla',

    data: {
        selectTipoTrabajador: null,
        selectPeriodoPlanilla: null,
        tipoPlanilla: '01'
    },

    stores: {
        tipostrabajador: {
            type: 'StipoTrabajador',
            autoLoad: true
        },
        conceptos: {
            type: 'SconceptoAsignado',
            autoLoad: true,
            filters: [{
                    property: 'ID_TTRABAJADOR',
                    operator: 'EQ',
                    value: '{selectTipoTrabajador.idTtrabajador}'
                }, {
                    property: 'ID_TPLANILLA',
                    operator: 'EQ',
                    value: '{tipoPlanilla}'
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
