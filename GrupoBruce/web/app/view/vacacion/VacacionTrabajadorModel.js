Ext.define('GrupoBruce.view.vacacion.VacacionTrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMvacacionTrabajador',
    data: {
        title: 'Lista de vacaciones',
        recordTrabajador: null,
        selectVacacion: null,
        selectPeriodo: null,
        selectTipo: null,
        salida: new Date(),
        fecha_base: null,
        nro_dias: 15
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
        tiempo_servicio: {
            get: function (get) {
                var alta = get('recordTrabajador').get('ultimaAlta'), periodo = get('selectPeriodo'), servicio = 0, base;
                if (periodo) {
                    servicio = periodo.get('idPVacacion') - alta.getFullYear();
                    base = Ext.Date.add(alta, Ext.Date.YEAR, servicio - 1);
                this.set({fecha_base: base});
                }
                return servicio;
            }
        },
        retorno: {
            get: function (get) {
                var dias = get('dias'), salida = get('salida'), fecha;
                fecha = Ext.Date.add(salida, Ext.Date.DAY, dias + 1);
                return fecha;
            },
            set: function (value) {

            }
        },
        dias: function (get) {
            var tipo = get('selectTipo'), numero;
            numero = tipo ? tipo.get('pagar') ? get('nroDias') : 30 : 0;
            return numero;
        },
        nroDias: function (get) {
            var nro = get('nro_dias');
            nro = nro === "" || nro < 0 ? 0 : nro > 30 ? 30 : nro;
            return nro;
        }
    }

});
