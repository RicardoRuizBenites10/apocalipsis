Ext.define('GrupoBruce.view.acceso.AccesoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMacceso',
    data: {
        title: 'Lista de acceso asignados',
        recordRol: null
    },

    stores: {
        accesosRol: {
            type: 'Sacceso',
            autoLoad: true,
            filters: [{
                    property: 'idRol',
                    value: '{recordRol.idRol}'
                }],
            proxy: {
                type: 'ajax',
                url: 'accesosRol',
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                    successProperty: 'success'
                },
                writer: {
                    type: 'json',
                    writeAllFields: true
                }
            }
        }
    }

});
