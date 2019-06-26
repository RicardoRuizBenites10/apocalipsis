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
        , carroceriaLast: {
            type: 'Scarroceria',
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
                    value: '{selectCarroceriaTipo.idCarmod}'
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
            var store = get('carroceriaLast');
            console.log('aaaa');
//            var pro = this;
            new Ext.Promise(function (resolve, reject) {
                store.load({
                    callback: function (records, operation, success) {
                        if (success) {
                            // Use the provided "resolve" method  to drive the promise:
                            if(records.length){
                                return records[1].get('codigo');
                            }
                            console.log(records.length);
//                            resolve(records);
                        } else {
                            // Use the provided "reject" method  to drive the promise:
                            console.log('nonono');
//                            reject("Error loading Companies.");
                        }
                    }
                });
            });
//                    .then(function (content) {
//                console.log('dododo');
//            });
            console.log('zzzz');
        }
    }

});
