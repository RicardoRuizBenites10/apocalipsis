Ext.define('GrupoBruce.view.horario.HorarioModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMhorario',
    data: {
        recordTurno: null,
        selectHorario: null,
        selectDia: null
    },

    stores: {
        horarios: {
            type: 'Shorario',
            autoLoad: true,
            filters: [{
                    property: 'ID_TURNO',
                    operator: 'EQ',
                    value: '{recordTurno.idTurno}'
                }]
        },
        dias: {
            type: 'Sdia',
            autoLoad: true
        }
    }
});
