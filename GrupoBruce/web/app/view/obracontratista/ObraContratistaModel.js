Ext.define('GrupoBruce.view.obracontratista.ObraContratistaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobracontratista',

    data: {
        recordObra: null,
        selectObraContratista: null
    },

    stores: {
        obracontratistas: {
            type: 'Sobracontratista',
            autoLoad: true,
            filters: [{
                    property: 'ID_OBRA',
                    operator: 'eq',
                    value: '{recordObra.idObra}'
                }]
        },
        contratistas: {
            type: 'Scontratista',
            autoLoad: true,
            filters: [{
                    property: 'ID_CONTRATISTA',
                    operator: 'nin',
                    value: '{nocontratista}'
                }]
        },
        etapaprocesos: {
            type: 'Setapaproceso',
            autoLoad: true
        }
    },

    formulas: {
        nocontratista: function (get) {
            var store = Ext.getCmp('id_wobracontratista').getStore();
            var nrecord = [];
            store.each(function (item) {
                nrecord.push(item.get('idContratista'));
            });
            return store.getCount() > 0 ? nrecord.toString() : 0;
        }
    }

});
