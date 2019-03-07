Ext.define('GrupoBruce.view.trabajador.TrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtrabajador',

    data: {
        pageSize: null
    },

    stores: {
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true,
            pageSize: '{pageSize ? pageSize : 25}',
            sorters: [
                {property: 'idTrabajador', direction: 'ASC'}
            ]
//            ,listeners: {
//                beforeload: function (store) {
//                    store.getProxy().setExtraParams({});
//                }
//            }
        }
    },

    formulas: {
        hasChild: function (get) {
            var select = get('selectTrabajador');
            return select ? select.get('nroHijos') === 0 : true;
        }
    }

});
