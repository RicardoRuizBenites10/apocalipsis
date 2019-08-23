Ext.define('GrupoBruce.view.usuario.UsuarioModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMusuario',
    data: {
        selectUsuario: null,
        selectTrabajador: null,
        selectEmpresa: null,
        newItem: false
    },

    stores: {
        usuarios: {
            type: 'Susuario',
            autoLoad: true
        },

        empresas: {
            type: 'Sempresa',
            autoLoad: true
        },

        acc_sucursals: {
            type: 'Ssucursal',
            autoLoad: true,
            filters: [{
                    property: 'idEmpresa',
                    operator: 'eq',
                    value: '{selectEmpresa.idEmpresa}'
                }]
        },

        def_sucursal: {
            type: 'Ssucursal',
            autoLoad: true,
            filters: [{
                    property: 'idSucursal',
                    operator: 'in',
                    value: '{tag_sucursals.value}'
                },{
                    property: 'idEmpresa',
                    operator: 'eq',
                    value: '{selectEmpresa.idEmpresa}'
                }],
            listeners: {
                beforeload: function (store) {
                    var filter = store.getFilters().getAt(0);
                    filter.setValue(filter.getValue().toString());
                }
            }
        },

        trabajadors: {
            type: 'Strabajador',
            autoLoad: true,
            sorters: [
                {property: 'apPaterno', direction: 'ASC'},
                {property: 'apMaterno', direction: 'ASC'},
                {property: 'nombres', direction: 'ASC'}
            ],
            listeners: {
                beforeload: function (store) {
                    var query = Ext.getCmp('id_trabajadorUsuario');
                    var valor = query !== undefined ? query.getValue() : 'x1';
                    store.getProxy().setExtraParam("query", valor);
                }
            }
        },
        rols: {
            type: 'Srol',
            autoLoad: true
        }
    },

    formulas: {
        vPass: function (get) {
            return 'password';
        }
    }

});
