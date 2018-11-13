Ext.define('GrupoBruce.view.trabajador.TrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtrabajador',

    data: {
        name: 'GrupoBruce'
    },

    stores: {
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true,
            pageSize: 15,
            sorters: [
                {property: 'idTrabajador', direction: 'ASC'}
            ]
        }
    },

    formulas: {
        hasChild: function (get) {
            var select = get('selectTrabajador');
            return select ? select.get('nroHijos') === 0 : true;
        }
    }

});
