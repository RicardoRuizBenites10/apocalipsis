Ext.define('GrupoBruce.view.carroceria.CarroceriaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcarroceria',

    data: {
        newRegister: true,
        selectCarroceriaModelo: null,
        selectCarroceriaTipo: null,
        selectCarroceriaFalda: null,
        selectChasisProveedor: null
    },

    stores: {
        carrocerias: {
            type: 'Scarroceria',
            autoLoad: true
        },
        carroceriamodelos: {
            type: 'Scarroceriamodelo',
            autoLoad: true
        },
        carroceriatipos: {
            type: 'Scarroceriatipo',
            loading: true,
            autoLoad: true,
            filters: [{
                    property: 'ID_CARMOD',
                    value: '{selectCarroceriaModelo.idCarmod}'
                }]
        },
        chasisproveedors: {
            type: 'Schasisproveedor',
            autoLoad: true
        },
        chasiss: {
            type: 'Schasis',
            autoLoad: true,
            loading: true,
            filters: [{
                    property: 'ID_CHAPRO',
                    value: '{selectChasisProveedor.idChapro}'
                }, {
                    property: 'ID_CARMOD',
                    value: '{selectCarroceriaModelo.idCarmod}'
                }]
        },
        carroceriafaldas: {
            type: 'Scarroceriafalda',
            autoLoad: true
        },
        carroceriaLast: {
            type: 'Scarroceria',
            autoLoad: true,
            loading: true,
            proxy: {
                type: 'ajax',
                url: 'carroceriaLast',
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                    totalProperty: 'total',
                    successProperty: 'success'
                }
            },
            filters: [{
                    property: 'ID_CARMOD',
                    value: '{selectCarroceriaModelo.idCarmod}'
                }, {
                    property: 'ID_CARTIP',
                    value: '{selectCarroceriaTipo.idCartip}'
                }, {
                    property: 'ID_CARFAL',
                    value: '{selectCarroceriaFalda.idCarfal}'
                }],
            sorters: [{
                    property: 'CODIGO',
                    direction: 'DESC'
                }]
        }
    },

    formulas: {
        codigoLetra: function (get) {
            if (get('newRegister')) {
                var mod = get('selectCarroceriaModelo'), tip = get('selectCarroceriaTipo'), fal = get('selectCarroceriaFalda');
                var storeCL = get('carroceriaLast');
                var letras, numeros = '', codigo;
                if (mod && tip && fal) {
                    var idLast = storeCL.count() > 0 ? parseInt(storeCL.getAt(0).get('codigo')) + 1 : 1, numeros = idLast.toString().padStart(3, '0');
                    letras = mod.get('idCarmod') + tip.get('idCartip') + fal.get('idCarfal');
                    codigo = letras.substr(0, 3) + '-' + numeros;
                } else {
                    codigo = '';
                }
                console.log('misnumeros : ' + numeros);
                this.set('codigo', numeros);
                return codigo;
            }
        }
    }

});
