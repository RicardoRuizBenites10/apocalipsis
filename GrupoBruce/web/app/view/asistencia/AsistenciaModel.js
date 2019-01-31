Ext.define('GrupoBruce.view.asistencia.AsistenciaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasistencia',

    data: {
        desde: new Date(),
        pageSize: null
    },

    stores: {
        horarios: {
            type: 'Shorario',
            autoLoad: true
        },
        asistencias: {
            type: 'Sasistencia',
            autoLoad: true,
            pageSize: '{pageSize ? pageSize : 25}',
            filters: [{
                    property: 'FECHA',
                    operator: 'eq',
                    value: '{desde}'
                }]
        }
    },

    formulas: {
        diaHorario: function (get) {
            var dia, numberDay = get('desde').getDay(), horario = get('horarios');
            horario.reload();
            console.log(horario.getCount());
            horario.each(function (item) {
                console.log(1);
//                if (numberDay === item.get('idDia')) {
//                    dia = item;
//                }
            });
            return 10;
        }
    }

});
