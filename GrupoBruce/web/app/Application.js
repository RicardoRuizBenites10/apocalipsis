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
        'GrupoBruce.store.Acceso',
        'GrupoBruce.store.Archivo',
        'GrupoBruce.store.Area',
        'GrupoBruce.store.AsignacionDetalle',
        'GrupoBruce.store.AsignacionEquipo',
        'GrupoBruce.store.Asistencia',
        'GrupoBruce.store.Ausencia',
        'GrupoBruce.store.Cargo',
        'GrupoBruce.store.Comisionrp',
        'GrupoBruce.store.ContratoTrabajador',
        'GrupoBruce.store.Ecivil',
        'GrupoBruce.store.EquipoInformatico',
        'GrupoBruce.store.Empresa',
        'GrupoBruce.store.EntidadFinanciera',
        'GrupoBruce.store.EstadoContrato',
        'GrupoBruce.store.EstadoEquipo',
        'GrupoBruce.store.EstadoEstudio',
        'GrupoBruce.store.EstadoMantenimiento',
        'GrupoBruce.store.EstadoTrabajador',
        'GrupoBruce.store.Formacion',
        'GrupoBruce.store.FormaPago',
        'GrupoBruce.store.Funcion',
        'GrupoBruce.store.Genero',
        'GrupoBruce.store.Hijo',
        'GrupoBruce.store.Mantenimiento',
        'GrupoBruce.store.MantenimientoDetalle',
        'GrupoBruce.store.MantenimientoProceso',
        'GrupoBruce.store.Menu',
        'GrupoBruce.store.Marca',
        'GrupoBruce.store.Nacionalidad',
        'GrupoBruce.store.Periocidad',
        'GrupoBruce.store.PeriodoVacacion',
        'GrupoBruce.store.Proceso',
        'GrupoBruce.store.RegimenPensionario',
        'GrupoBruce.store.Rol',
        'GrupoBruce.store.Sucursal',
        'GrupoBruce.store.Trabajador',
        'GrupoBruce.store.TiempoAusencia',
        'GrupoBruce.store.TiempoContrato',
        'GrupoBruce.store.TipoAusencia',
        'GrupoBruce.store.TipoContrato',
        'GrupoBruce.store.TipoDocumento',
        'GrupoBruce.store.TipoEquipo',
        'GrupoBruce.store.TipoEstudio',
        'GrupoBruce.store.TipoFormacion',
        'GrupoBruce.store.TipoMantenimiento',
        'GrupoBruce.store.TipoTrabajador',
        'GrupoBruce.store.TipoVacacion',
        'GrupoBruce.store.Usuario',
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
