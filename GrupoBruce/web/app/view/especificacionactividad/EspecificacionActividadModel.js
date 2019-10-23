Ext.define('GrupoBruce.view.especificacionactividad.EspecificacionActividadModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMespecificacionactividad',
    data: {
        etapas: null
    },
    
    stores: {
        etapaprocesos: {
            type: 'Setapaproceso',
            autoLoad: true
        },
        especificacionactividads: {
            type: 'Sespecificacionactividad',
            autoLoad: true,
            autoSync: '{!newRegister}',
            trackRemoved: '{!newRegister}',
            filters: [{
                    property: 'ID_ESPECIFICACION',
                    operator: 'eq',
                    value: '{recordEspecificacion.idEspecificacion}'
                }]
        },
        actividads: {
            type: 'Sactividad',
            autoLoad: true,
            filters: [{
                    property: 'ID_EPROCESO',
                    operator: 'in',
                    value: '{etapas}'
            },{
                    property: 'ID_ACTIVIDAD',
                    operator: 'nin',
                    value: '{noactividad}'
            }]
        }
    },
    
    formulas: {
        noactividad: function(get){
            var store = Ext.getCmp('id_wespecificacionactividad').getStore();
            var nm = [];
            store.each(function (item) {
                nm.push(item.get('idActividad'));
            });
            return store.getCount() > 0 ? nm.toString() : 0;
        }
    }

});
