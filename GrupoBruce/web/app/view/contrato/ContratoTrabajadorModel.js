Ext.define('GrupoBruce.view.contrato.ContratoTrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcontratoTrabajador',

    data: {
        recordTrabajador: null,
        selectTiempo: null,
        inicio: new Date()
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
        estadoContratos: {
            type: 'SestadoContrato',
            autoLoad: true
        },
        tiempoCotratos: {
            type: 'StiempoContrato',
            autoLoad: true
        },
        tipoContratos: {
            type: 'StipoContrato',
            autoLoad: true
        }
    },

    formulas: {
        fin: {
            get: function (get) {
                var cantMeses = get('cantMeses'), inicio = get('inicio'), fecha = '';
                if (cantMeses > 0) {
                    fecha = Ext.Date.add(inicio, Ext.Date.MONTH, cantMeses);
                    fecha = Ext.Date.add(fecha, Ext.Date.DAY, -1);
                    fecha = Ext.Date.format(fecha, 'd/m/Y')
                }
                return fecha;
            }
        },
        cantMeses: function (get) {
            var tiempo = get('selectTiempo'), meses;
            meses = tiempo ? tiempo.get('nroMeses') : 0;
            return meses;
        }
    }

});
