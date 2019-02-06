Ext.define('GrupoBruce.view.textralaboral.TextralaboralModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtextralaboral',
    data: {
        selectTextralaboral: null,
        selectTrabajador: null,
        desde: new Date()
    },

    stores: {
        textralaborals: {
            type: 'Stextralaboral',
            autoLoad: true,
            filters: [{
                    property: 'FECHA',
                    operator: 'eq',
                    value: '{desde}'
                }]
        },
        tiposTextra: {
            type: 'StipoTextra',
            autoLoad: true
        },
        actividads: {
            type: 'Sactividad',
            autoLoad: true,
            sorters: [
                {property: 'NOMBRE', direction: 'ASC'}
            ],
            listeners: {
                beforeload: function (store) {
                    var query = Ext.getCmp('id_actividad_hextra');
                    var valor = query !== undefined ? query.getValue() : 'x1';
                    store.getProxy().setExtraParam("query", valor);
                }
            }
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
                    var query = Ext.getCmp('id_trabajador_hextra');
                    var valor = query !== undefined ? query.getValue() : 'x1';
                    store.getProxy().setExtraParam("query", valor);
                }
            }
        }
    }

});
