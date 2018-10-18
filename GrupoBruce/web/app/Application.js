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
        'GrupoBruce.store.Comisionrp',
        'GrupoBruce.store.ContratoTrabajador',
        'GrupoBruce.store.Ecivil',
        'GrupoBruce.store.Empresa',
        'GrupoBruce.store.EntidadFinanciera',
        'GrupoBruce.store.EstadoContrato',
        'GrupoBruce.store.EstadoTrabajador',
        'GrupoBruce.store.FormaPago',
        'GrupoBruce.store.Genero',
        'GrupoBruce.store.Hijo',
        'GrupoBruce.store.Nacionalidad',
        'GrupoBruce.store.Periocidad',
        'GrupoBruce.store.PeriodoVacacion',
        'GrupoBruce.store.RegimenPensionario',
        'GrupoBruce.store.Sucursal',
        'GrupoBruce.store.Trabajador',
        'GrupoBruce.store.TiempoContrato',
        'GrupoBruce.store.TipoContrato',
        'GrupoBruce.store.TipoDocumento',
        'GrupoBruce.store.TipoTrabajador',
        'Grupobruce.store.Vacacion'
    ],

    launch: function () {
        var loggedIn = Ext.decode(localStorage.getItem("sesionEstado"));
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
