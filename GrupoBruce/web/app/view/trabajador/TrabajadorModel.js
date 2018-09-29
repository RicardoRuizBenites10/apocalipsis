Ext.define('GrupoBruce.view.trabajador.TrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtrabajador',
    
    data: {
        name: 'GrupoBruce'
    },

    stores: {
        trabajadors: {
            type: 'Strabajador'
        },
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
        },
        contratos: {
            type: 'ScontratoTrabajador',
            listeners: {
                beforeload: function (store) {
                    var idTrabajador = "46099060";//Ext.getCmp('filterText').value;
                    store.getProxy().setExtraParam("idTrabajador", idTrabajador);
                }
            }
            , autoLoad: true
        }
    },
    
    formulas: {
        hasChild: function(get){
            var select = get('selectTrabajador');
            return select ? select.get('nroHijos') === 0 : true;
        }
    }

});
