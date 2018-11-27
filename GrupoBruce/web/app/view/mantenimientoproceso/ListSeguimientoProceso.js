Ext.define('GrupoBruce.view.mantenimientoproceso.ListSeguimientoProceso', {
    extend: 'Ext.window.Window',
    alias: 'widget.WseguimientoProceso',
    reference: 'list_seguimientoProceso',

    modal: true,
    resizable: false,
    closable: true,
    title: 'Seguimiento de manteniminiento de equipo',

    items: [{
            xtype: 'grid',
            width: 600,
            height: 400,
            bind: {
                store: '{mantenimientosProceso}'
            },
            allowDeselect: true,

            style: 'border: solid rgb(234,234,236) 1px',
            columns: [{
                    text: 'Fecha',
                    dataIndex: 'fecha',
                    formatter: 'date("d/m/Y")'
                }, {
                    text: 'Detalle',
                    dataIndex: 'observacion',
                    align: 'left',
                    flex: 1
                }, {
                    text: 'Etapa',
                    dataIndex: 'idEmantenimiento',
                    align: 'left',
                    renderer: function (val) {
                        switch (val) {
                            case '01':
                                return 'Requerido';
                            case '02':
                                return 'Asignado';
                            case '03':
                                return 'En preceso';
                            case '04':
                                return 'Terminado';
                            case '05':
                                return 'En entrega';
                            case '06':
                                return 'Recepcionado';
                        }
                    }
                }],

            dockedItems: [{
                    xtype: 'pagingtoolbar',
                    dock: 'bottom',
                    bind: {
                        store: '{mantenimientosProceso}'
                    },
                    displayInfo: true,
                    displayMsg: 'Mostrando registros {0} - {1} de {2}',
                    emptyMsg: "No hay registros que mostrar"
                }]
        }]

});