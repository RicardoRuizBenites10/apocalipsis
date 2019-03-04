Ext.define('GrupoBruce.view.pplanilla.PplanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMpplanilla',

    data: {
        selectTipoTrabajador: null,
        selectPeriodoPlanilla: null,
        pageSize: null,
//        allRecord: false
    },

    stores: {
        tipostrabajador: {
            type: 'StipoTrabajador',
            autoLoad: true
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
            pageSize: '{pageSize ? pageSize : 25}',
            filters: [{
                    property: 'PP.ID_PPLANILLA',
                    operator: 'EQ',
                    value: '{selectPeriodoPlanilla.idPplanilla}'
                }]
        }
    },

    formulas: {
        allRecord: function (get) {
            var planillas = get('planillasTareo');
            console.log('pp: ' + get('selectPeriodoPlanilla'));
            console.log('raro: ' + planillas.pageSize + '-' + planillas.totalCount);
            return get('selectPeriodoPlanilla') ? planillas.pageSize >= planillas.totalCount : false;
        }
    }

});
