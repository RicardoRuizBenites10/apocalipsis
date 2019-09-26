Ext.define('GrupoBruce.view.contrato.ContratoTrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcontratoTrabajador',

    data: {
        title: 'Lista de contratos',
        recordTrabajador: null,
        selectContrato: null,
        selectArea: null,
        selectTiempo: null,
        currentDate: new Date()
    },

    stores: {
        contratos: {
            type: 'ScontratoTrabajador',
            autoLoad: true,
            filters: [{
                    property: 'idTrabajador',
                    value: '{recordTrabajador.idTrabajador}'
                }]
        },
        tiempoCotratos: {
            type: 'StiempoContrato',
            autoLoad: true
        },
        tipoContratos: {
            type: 'StipoContrato',
            autoLoad: true
        },
        areas: {
            type: 'Sarea',
            autoLoad: true
        },
        cargos: {
            type: 'Scargo',
            autoLoad: true,
            filters: [{
                    property: 'idArea',
                    value: '{selectArea}'
                }]
        }
    },

    formulas: {
        inicio: {
            get: function (get) {
                var contrato = get('selectContrato');
                return contrato ? contrato.get('fechaInicio') : get('currentDate');
            },
            set: function (value) {
                this.set({currentDate: value});
            }
        },
        fin: {
            get: function (get) {
                var meses, inicio, fecha = '';
                meses = get('cantMeses');
                inicio = get('currentDate');
                if (inicio !== '') {
                    if (meses > 0) {
                        fecha = Ext.Date.add(inicio, Ext.Date.MONTH, meses);
                        fecha = Ext.Date.add(fecha, Ext.Date.DAY, -1);
                    }
                }
                return fecha;
            },
            set: function (value) {

            }
        },
        cantMeses: function (get) {
            var tiempo = get('selectTiempo'), meses;
            meses = tiempo ? tiempo.get('nroMeses') : 0;
            return meses;
        }
    }

});
