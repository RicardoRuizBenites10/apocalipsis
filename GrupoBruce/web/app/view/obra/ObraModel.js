Ext.define('GrupoBruce.view.obra.ObraModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobra',
    data: {
        selectObraTipo: null,
        selectObra: null,
        currentDate: new Date(),
        numeroOP: '',
        anioOP: ''
    },

    stores: {
        obratipos: {
            type: 'Sobratipo',
            autoLoad: true
        },
        proformas: {
            type: 'Sproforma',
            autoLoad: true
        },
        estadoobras: {
            type: 'Sestadoobra',
            autoLoad: true
        },
        obras: {
            type: 'Sobra',
            autoLoad: true
        }
    },

    formulas: {
        currentYear: function (get) {
            var fecha = new Date();
            var ano = (fecha.getFullYear()).toString().substr(2);
            return ano;
        },
        nombreOP: function (get) {
            var tipoOP = get('selectObraTipo'), numeroOP = get('numeroOP'), anioOP = get('anioOP');
            var nomOP = '';
            if (tipoOP !== null && numeroOP !== '' && numeroOP > 0) {
                nomOP = tipoOP.get('idObrtip') + '-' + numeroOP.toString().padStart(3, 0) + '-' + anioOP;
            }
            return nomOP;
        }
    }

});
