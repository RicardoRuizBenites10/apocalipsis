Ext.define('GrupoBruce.view.requerimiento.ListActividadRequerimiento',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistactividadrequerimiento',
    reference: 'list_actividadrequerimiento',
    id: 'id_wlistactividadrequerimiento',
    
    bind: {
        store: '{requerimientos}',
        selection: '{selectRequerimiento}'
    },
    allowDeselect: true,
    
    columns: [{
            text: 'Actividad',
    }, {
        text: 'Situación'
    }, {
        
    }]
});