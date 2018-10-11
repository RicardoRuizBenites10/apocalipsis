Ext.define('GrupoBruce.view.hijo.HijoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMhijo',
    data: {
        title: 'Lista de hijos',
        recordTrabajador: null
    },

    store: {
        hijos: {
            type: 'Shijo',
            autoLoad: true,
            filters: [{
                    property: 'idTrabajador',
                    value: '{recordTrabajador.idTrabajador}'
                }]
        },
        generos: {
            type: 'Sgenero',
            autoLoad: true
        }
    }
});
