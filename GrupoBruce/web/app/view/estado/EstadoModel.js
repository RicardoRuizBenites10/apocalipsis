Ext.define('GrupoBruce.view.estado.EstadoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMestado',
    data: {
        title: 'Lista de etapas',
        recordProceso: null,
        selectEstado: null
    },
    
    stores: {
        estados: {
            type: '{"S" + recordProceso.entidad}',
            autoLoad: true
        }
    }

});
