Ext.define('GrupoBruce.view.prestamo.PrestamoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMprestamo',

    data: {
        recordTrabajador: null,
        selectPrestamo: null,
        hoy: new Date()
    },

    stores: {
        prestamos: {
            type: 'Sprestamo',
            autoLoad: true,
            filters: [{
                    property: 'idTrabajador',
                    operator: 'eq',
                    value: '{recordTrabajador.idTrabajador}'
                }]
        }
    }

});
