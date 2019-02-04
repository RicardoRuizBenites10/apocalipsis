Ext.define('GrupoBruce.view.calendario.FormCalendario', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformCalendario',
    reference: 'form_calendario',

    controller: 'Ccalendario',
    viewModel: {
        type: 'VMcalendario'
    }
});