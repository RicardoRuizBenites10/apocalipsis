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
        'GrupoBruce.store.Ausencia',
        'GrupoBruce.store.Comisionrp',
        'GrupoBruce.store.ContratoTrabajador',
        'GrupoBruce.store.Ecivil',
        'GrupoBruce.store.Empresa',
        'GrupoBruce.store.EntidadFinanciera',
        'GrupoBruce.store.EstadoContrato',
        'GrupoBruce.store.EstadoEstudio',
        'GrupoBruce.store.EstadoTrabajador',
        'GrupoBruce.store.Formacion',
        'GrupoBruce.store.FormaPago',
        'GrupoBruce.store.Genero',
        'GrupoBruce.store.Hijo',
        'GrupoBruce.store.Nacionalidad',
        'GrupoBruce.store.Periocidad',
        'GrupoBruce.store.PeriodoVacacion',
        'GrupoBruce.store.RegimenPensionario',
        'GrupoBruce.store.Sucursal',
        'GrupoBruce.store.Trabajador',
        'GrupoBruce.store.TiempoAusencia',
        'GrupoBruce.store.TiempoContrato',
        'GrupoBruce.store.TipoAusencia',
        'GrupoBruce.store.TipoContrato',
        'GrupoBruce.store.TipoDocumento',
        'GrupoBruce.store.TipoEstudio',
        'GrupoBruce.store.TipoFormacion',
        'GrupoBruce.store.TipoTrabajador',
        'GrupoBruce.store.TipoVacacion',
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
