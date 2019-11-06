Ext.define('GrupoBruce.view.proforma.ProformaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMproforma',
    data: {
        selectProforma: null,
        selectCarroceria: null
    },

    stores: {
        proformas: {
            type: 'Sproforma',
            autoLoad: true
        },
        clientes: {
            type: 'Scliente',
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
        },
        carrocerias: {
            type: 'Scarroceria',
            autoLoad: true,
            filters: [{
                    property: 'ID_CARMOD',
                    value: '{selectCarroceriaModelo.idCarmod}'
                }, {
                    property: 'ID_CARTIP',
                    value: '{selectCarroceriaTipo.idCartip}'
                }, {
                    property: 'ID_CARFAL',
                    value: '{selectCarroceriaFalda.idCarfal}'
                }, {
                    property: 'ID_CHAPRO',
                    value: '{selectChasisProveedor.idChapro}'
                }, {
                    property: 'ID_CHASIS',
                    value: '{selectChasis.idChasis}'
                }]
        },
        currentCarroceria: {
            type: 'Scarroceria',
            loading: true,
            autoLoad: true,
            filters: [{
                    property: 'ID_CARROCERIA',
                    operator: 'eq',
                    value: '{recordProforma.idCarroceria}'
                }]
        }
    },

    formulas: {
        carroceriaProforma: function (get) {
            var store = get('currentCarroceria');
            var carroceria = store.getCount() > 0 ? store.getAt(0) : null;
            return carroceria;
        }
    }

});