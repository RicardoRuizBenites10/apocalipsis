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
        initialDay: 30,
        initialValue: 1
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
                var dias = get('diasTipo'), salida = get('salida'), fecha, vacacion = get('selectVacacion');
                fecha = get('initialValue') > 0 && vacacion ? vacacion.get('fechaRetorno') : Ext.Date.add(salida, Ext.Date.DAY, dias + 1);
                return fecha;
            },
            set: function (value) {
                this.set({initialValue: this.get('initialValue') - 1});
            }
        },
        diasTipo: {
            get: function (get) {
                var tipo = get('selectTipo'), numero = 0;
                if (tipo) {
                    numero = tipo.get('pagar') ? get('nroDias') : 30;
                }
                return numero;
            }
        },
        nroDias: {
            get: function (get) {
                var vacacion = get('selectVacacion'), nro;
                nro = get('initialValue') > 0 && vacacion ? vacacion.get('diasTomados') : get('initialDay');
                return nro;
            },
            set: function (value) {
                this.set({
                    initialValue: this.get('initialValue') - 1,
                    initialDay: value
                });
            }
        }
    }

});
