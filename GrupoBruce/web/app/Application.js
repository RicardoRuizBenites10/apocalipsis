Ext.define('GrupoBruce.Application', {
    extend: 'Ext.app.Application',

    name: 'GrupoBruce',

    quickTips: false,
    platformConfig: {
        desktop: {
            quickTips: true
        }
    },

    stores: [
        'GrupoBruce.store.Personnel',
        'GrupoBruce.store.Trabajador',
        'GrupoBruce.store.Nacionalidad',
        'GrupoBruce.store.TipoDocumento',
        'GrupoBruce.store.Genero',
        'GrupoBruce.store.Ecivil',
        'GrupoBruce.store.TipoTrabajador',
        'GrupoBruce.store.RegimenPensionario',
        'GrupoBruce.store.Comisionrp',
        'GrupoBruce.store.EntidadFinanciera',
        'GrupoBruce.store.FormaPago',
        'GrupoBruce.store.Periocidad',
        'GrupoBruce.store.EstadoTrabajador',
        'GrupoBruce.store.Empresa',
        'GrupoBruce.store.Sucursal'
    ],

    launch: function () {
        var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
        Ext.create({
                xtype: loggedIn ? 'app-main' : 'login'
            });

    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
                function (choice) {
                    if (choice === 'yes') {
                        window.location.reload();
                    }
                }
        );
    }
});
