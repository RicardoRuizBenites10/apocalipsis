Ext.define('GrupoBruce.view.vacacion.VacacionTrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMvacacionTrabajador',
    data: {
        title: 'Lista de vacaciones',
        recordTrabajador: null,
        selectVacacion: null,
        selectTipo: null,
        salida: new Date()
    },

    stores: {
        vacacions: {
            type: 'Svacacion',
            autoLoad: true,
            filters: [{
                    property: 'idTrabajador',
                    value: '{recordTrabajador.idTrabajador}'
                }]
        },
        periodos: {
            type: 'SperiodoVacacion',
            autoLoad: true
        },
        tipos: {
            type: 'StipoVacacion',
            autoLoad: true,
            filters: [{
                    property: 'situacion',
                    value: true
                }]
        }
    },

    formulas: {
        retorno: {
            get: function (get) {
                var date = get('inicio'), vacacion = get('selectVacacion');
//                date = Ext.Date.add(date, Ext.Date.DAY, get('dias'));
                
                console.log('get de retorno');
                return vacacion ? vacacion.fechaRetorno : new Date();
            },
            set: function (value) {
                console.log('Set de retorno');
            }
        },
        dias: function (get) {
            var tipo = get('selectTipo'), numero;
            numero = tipo ? (tipo.pagar ? 1 : 30) : 10;
            return numero;
        }
    }

});
