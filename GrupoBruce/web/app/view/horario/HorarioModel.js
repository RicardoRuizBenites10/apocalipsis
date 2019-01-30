Ext.define('GrupoBruce.view.horario.HorarioModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMhorario',
    data: {
        selectHorario: null,
        selectDia: null
    },

    stores: {
        horarios: {
            type: 'Shorario',
            autoLoad: true
        },
        dias: {
            type: 'Sdia',
            autoLoad: true
        }
    }
});
