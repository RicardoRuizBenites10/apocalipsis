Ext.define('GrupoBruce.view.formacion.FormacionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMformacion',

    data: {
        title: 'Lista de estudios',
        recordTrabajador: null,
        selectFormacion: null
    },

    stores: {
        formacions: {
            type: 'Sformacion',
            autoLoad: true,
            filters: [{
                    property: 'idTrabajador',
                    value: '{recordTrabajador.idTrabajador}'
                }]
        },
        tiposFormacion: {
            type: 'StipoEstudio',
            autoLoad: true
        },
        estadosFormacion: {
            type: 'SestadoEstudio',
            autoLoad: true
        }
    }

});
