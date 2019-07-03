Ext.define('GrupoBruce.view.carroceria.CarroceriaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcarroceria',

    data: {
        newRegister: true,
        codigoNumero: '',
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
    },

    formulas: {
        codigoLetra: function (get) {
            var mod = get('selectCarroceriaModelo'), tip = get('selectCarroceriaTipo'), fal = get('selectCarroceriaFalda');
            var codigo = '', codigoNum = '';
            if (get('newRegister')) {
                if (mod && tip && fal) {
                    Ext.Ajax.request({
                        url: 'carroceriaLast',
                        method: 'POST',
                        async: false,
                        params: {ID_CARMOD: mod.get('idCarmod'), ID_CARTIP: tip.get('idCartip'), ID_CARFAL: fal.get('idCarfal')},
                        success: function (response, opts) {
                            var responseText = Ext.decode(response.responseText);
                            codigo = responseText.data;
                            codigoNum = codigo.substr(4, 3);
                        },
                        failurer: function (response, opts) {
                            console.log('Joder 2');
                        }
                    });
                    this.set('codigoNumero', codigoNum);
                }
                return codigo;
            }
        }
    }

});
