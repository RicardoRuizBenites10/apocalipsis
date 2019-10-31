Ext.define('GrupoBruce.view.proformadetalle.ProformaDetalleModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMproformadetalle',
    data: {
        recordProforma: null,
        recordCarroceria: null
    },

    stores: {
        proformadetalles: {
            type: 'Sproformadetalle',
            autoLoad: true,
            filters: [{
                    property: 'ID_CARROCERIA',
                    operator: 'eq',
                    value: '{recordCarroceria.idCarroceria}'
                }]
        }
    }

});
