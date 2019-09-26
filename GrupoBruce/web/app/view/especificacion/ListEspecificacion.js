Ext.define('GrupoBruce.view.especificacion.ListEspecificación',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistespecificacion',
    reference: 'list_especificacion',
    id: 'id_wlistespecificacion',
    
    bind: {
        store: '{especificacions}',
        selection: '{selectEspecificacion}'
    },
    allowDeselect: true,
    
    columns: [{
            text: 'Nombre',
            dataIndex: 'descripcion'
    },{
        text: 'Situacion',
        dataIndex: 'situacion'
    }]
    
});