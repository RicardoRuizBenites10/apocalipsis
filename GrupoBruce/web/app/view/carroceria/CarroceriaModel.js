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
            loading: true,
            autoLoad: true,
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
        }
//        ,carroceriaLast: {
//            type: 'Scarroceria',
//            loading: true,
//            autoLoad: true,
//            proxy: {
//                type: 'ajax',
//                url: 'carroceriaLast',
//                reader: {
//                    type: 'json',
//                    rootProperty: 'data',
//                    totalProperty: 'total',
//                    successProperty: 'success'
//                }
//            },
//            filters: [{
//                    property: 'ID_CARMOD',
//                    value: '{selectCarroceriaModelo.idCarmod}'
//                }, {
//                    property: 'ID_CARTIP',
//                    value: '{selectCarroceriaTipo.idCartip}'
//                }, {
//                    property: 'ID_CARFAL',
//                    value: '{selectCarroceriaFalda.idCarfal}'
//                }],
//            sorters: [{
//                    property: 'CODIGO',
//                    direction: 'DESC'
//                }]
//        }
    },

    formulas: {
        codigoLetra: function (get) {

//            if (get('newRegister')) {
//                var mod = get('selectCarroceriaModelo'), tip = get('selectCarroceriaTipo'), fal = get('selectCarroceriaFalda');
////                var storeCL = get('carroceriaLast');
//                var letras, numeros = '', codigo=80;
//                            console.log('Joder 0');
//                if (mod && tip && fal) {
//
////                    Ext.Ajax.request({
////                        url: 'carroceriaLast',
////                        jsonData: {ID_CARMOD: mod.get('idCarmod'), ID_CARTIP: tip.get('idCartip'), ID_CARFAL: fal.get('idCarfal')},
////                        method: 'POST',
////                        scope: this,
////                        success: function (response, opts) {
////                            console.log('Joder');
////                        },
////                        failurer: function (response, opts) {
////
////                        }
////                    }, this);
//
//
//                            console.log('Joder 2');
////                    var idLast = storeCL.count() > 0 ? parseInt(storeCL.getAt(0).get('codigo')) + 1 : 1, numeros = idLast.toString().padStart(3, '0');
////                    console.log('Contador : ' + storeCL.count());
////                    letras = mod.get('idCarmod') + tip.get('idCartip') + fal.get('idCarfal');
////                    codigo = letras.substr(0, 3) + '-' + numeros;
//
//                } else {
//                    codigo = '';
//                }
//                console.log('misnumeros : ' + numeros);
//                this.set('codigo', numeros);
//                return codigo;
//            }
        }
    }

});
