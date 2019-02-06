Ext.define('GrupoBruce.view.actividad.FormActividad',{
    extend: 'Ext.window.Window',
    alias: 'widget.WformActividad',
    reference: 'form_actividad',
    
    controller: 'Cactividad',
    viewModel: {
        type: 'VMactividad'
    }
});