Ext.define('GrupoBruce.view.asignacion.AsignacionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasignacion',

    data: {
        title: 'Lista de asignación de equipos',
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
            baseParams: {
                foo: "bar",
                bar: 'foo'
            },
            listeners: {
                beforeload: function (store) {
                    var query = Ext.getCmp('id_recepcionador');
                    console.log('Jiirds: ' + store);
//                    store.getProxy().setExtraParam("query", query);
                }
            }
        }
    }

});
