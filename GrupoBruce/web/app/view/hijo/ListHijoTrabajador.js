Ext.define('GrupoBruce.view.hijo.ListHijoTrabajador', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WhijoTrabajador',
    reference: 'list_hijoTrabajador',

    bind: {
        store: '{hijos}',
        selection: '{selectHijo}'
    },

    columns: [{
            text: 'DNI'
        }, {
            text: 'Nombres'
        }, {
            text: 'Edad'
        }, {
            text: 'Genero'
        }]

});