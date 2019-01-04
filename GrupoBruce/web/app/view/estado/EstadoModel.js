Ext.define('GrupoBruce.view.estado.EstadoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMestado',
    data: {
        title: 'Lista de etapas',
        recordProceso: null,
        selectEstado: null,
        selectPrecede: null,
        nuevo: true
    },
    
    stores: {
        estados: {
            type: '{"S" + recordProceso.entidad}',
            autoLoad: true
        }
    },
    
    formulas: {
        numOrden : function(get){
            var pre = get('selectPrecede');
            return pre ? pre.get('orden') + 1 : 1;
        }
    }

});
