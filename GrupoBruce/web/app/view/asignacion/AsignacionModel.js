Ext.define('GrupoBruce.view.asignacion.AsignacionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasignacion',

    data: {
        title: 'Lista de custodios de equipos informáticos',
        selectAsignacion: null,
        selectRecepcionador: null
    },

    stores: {
        asignacions: {
            type: 'SasignacionEquipo',
            autoLoad: true
        },
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true,
            sorters: [
                {property: 'apPaterno', direction: 'ASC'},
                {property: 'apMaterno', direction: 'ASC'},
                {property: 'nombres', direction: 'ASC'}
            ],
            listeners: {
                beforeload: function (store) {
                    var query = Ext.getCmp('id_recepcionador');
                    var valor = query !== undefined ? query.getValue() : 'x1';
                    store.getProxy().setExtraParam("query", valor);
                }
            }
        }
    }
});