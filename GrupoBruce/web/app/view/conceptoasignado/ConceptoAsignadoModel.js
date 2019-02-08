Ext.define('GrupoBruce.view.conceptoasignado.ConceptoAsignadoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMconceptoasignado',

    data: {
        selectConcepto: null,
        selectTipoPlanilla: null,
        recordTipoTrabajador: null,
        selectConceptoAsignado: null
    },

    stores: {
        conceptos: {
            type: 'Sconcepto',
            autoLoad: true,
            filters: [{
                    property: 'ID_TTRABAJADOR',
                    operator: 'EQ',
                    value: '{recordTipoTrabajador.idTtrabajador}'
                }, {
                    property: 'SITUACION',
                    operator: 'EQ',
                    value: true
                }],
            sorters: [{
                    property: 'ID_CONCEPTO',
                    direction: 'ASC'
                }]
        },
        tiposPlanilla: {
            type: 'StipoPlanilla',
            autoLoad: true
        },
        conceptosAsignado: {
            type: 'SconceptoAsignado',
            autoLoad: true,
            filters: [{
                    property: 'ID_TTRABAJADOR',
                    operator: 'eq',
                    value: '{recordTipoTrabajador.idTtrabajador}'
                }, {
                    property: 'ID_TPLANILLA',
                    operator: 'eq',
                    value: '{selectTipoPlanilla.idTipo}'
                }]
        }
    },

    formulas: {
        allowAsignar: function (get) {
            var selecttp = get('selectTipoPlanilla');
            return selecttp ? !get('selectConcepto') : !selecttp;
        }
    }

});
