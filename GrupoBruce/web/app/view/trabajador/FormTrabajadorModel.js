Ext.define('GrupoBruce.view.trabajador.FormTrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMformTrabajador',
    
    data: {
        name: 'GrupoBruce'
    },

    stores: {
        nacionalidads: {
            type: 'Snacionalidad',
            autoLoad: true
        },
        tipoDocumentos: {
            type: 'StipoDocumento',
            autoLoad: true
        },
        generos: {
            type: 'Sgenero',
            autoLoad: true
        },
        ecivils: {
            type: 'Secivil',
            autoLoad: true
        },
        estadoTrabajadors: {
            type: 'SestadoTrabajador',
            autoLoad: true
        },
        tipoTrabajadors: {
            type: 'StipoTrabajador',
            autoLoad: true
        },
        entidadFinancieras: {
            type: 'SentidadFinanciera',
            autoLoad: true
        },
        formaPagos: {
            type: 'SformaPago',
            autoLoad: true
        },
        periocidads: {
            type: 'Speriocidad',
            autoLoad: true
        },
        regimenPensionarios: {
            type: 'SregimenPensionario',
            autoLoad: true
        },
        comisionrps: {
            type: 'Scomisionrp',
            autoLoad: true
        },
        empresas: {
            type: 'Sempresa',
            autoLoad: true
        },
        sucursals: {
            type: 'Ssucursal',
            autoLoad: true
        }
    }

});