Ext.define('GrupoBruce.view.trabajador.FormTrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMformTrabajador',

    data: {
        selectRPensionario: null,
        selectEmpresa: null
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
            autoLoad: true,
            filters: [{
                    property: 'idRpensionario',
                    value: '{selectRPensionario.idRpensionario}'
                }]
        },
        empresas: {
            type: 'Sempresa',
            autoLoad: true
        },
        sucursals: {
            type: 'Ssucursal',
            autoLoad: true,
            filters: [{
                    property: 'idEmpresa',
                    value: '{selectEmpresa.idEmpresa}'
                }]
        },
        tiposEstudio: {
            type: 'StipoEstudio',
            autoLoad: true,
            filters: [{
                    property: 'situacion',
                    value: true,
                    operator: 'eq'
                }]
        },
        estadosEstudio: {
            type: 'SestadoEstudio',
            autoLoad: true
        }
    }

});