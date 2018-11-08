Ext.define('GrupoBruce.view.asignacion.ListAsignacion', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAsignacion',
    reference: 'list_asignacion',

    columns: [{
            text: 'Trabajador'
        }, {
            text: 'IP'
        }, {
            text: 'Usuario'
        }]

});