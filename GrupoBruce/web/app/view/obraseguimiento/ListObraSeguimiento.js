Ext.define('GrupoBruce.view.obraseguimiento.ListObraSeguimiento', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistobraseguimienti',
    reference: 'list_obraseguimiento',
    id: 'id_wlistobraseguimiento',

    bind: {
        store: '{obraseguimientos}',
        selection: '{selectObraSeguimiento}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Área'
        }, {
            text: 'Inicio'
        }, {
            text: 'Fin'
        }, {
            text: 'Inicio'
        }, {
            text: 'Fin'
        }, {
            text: 'Ubicación'
        }]
});