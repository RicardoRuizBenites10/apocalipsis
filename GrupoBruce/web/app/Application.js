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
        'GrupoBruce.store.Actividad',
        'GrupoBruce.store.ActividadMaterial',
        'GrupoBruce.store.Almuerzo',
        'GrupoBruce.store.Archivo',
        'GrupoBruce.store.Area',
        'GrupoBruce.store.AsignacionDetalle',
        'GrupoBruce.store.AsignacionEquipo',
        'GrupoBruce.store.Asistencia',
        'GrupoBruce.store.Ausencia',
        'GrupoBruce.store.Calendario',
        'GrupoBruce.store.Cargo',
        'GrupoBruce.store.Carroceria',
        'GrupoBruce.store.CarroceriaFalda',
        'GrupoBruce.store.CarroceriaModelo',
        'GrupoBruce.store.CarroceriaTipo',
        'GrupoBruce.store.Chasis',
        'GrupoBruce.store.ChasisProveedor',
        'GrupoBruce.store.Cliente',
        'GrupoBruce.store.Comisionrp',
        'GrupoBruce.store.Concepto',
        'GrupoBruce.store.ConceptoAsignado',
        'GrupoBruce.store.Contratista',
        'GrupoBruce.store.ContratoTrabajador',
        'GrupoBruce.store.Dia',
        'GrupoBruce.store.Ecivil',
        'GrupoBruce.store.EquipoInformatico',
        'GrupoBruce.store.Empresa',
        'GrupoBruce.store.EntidadFinanciera',
        'GrupoBruce.store.EspecificacionActividad',
        'GrupoBruce.store.Especificacion',
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
        'GrupoBruce.store.Horario',
        'GrupoBruce.store.Mantenimiento',
        'GrupoBruce.store.MantenimientoDetalle',
        'GrupoBruce.store.MantenimientoProceso',
        'GrupoBruce.store.Menu',
        'GrupoBruce.store.Marca',
        'GrupoBruce.store.MaterialFamilia',
        'GrupoBruce.store.MaterialSubfamilia',
        'GrupoBruce.store.MaterialUnidad',
        'GrupoBruce.store.Nacionalidad',
        'GrupoBruce.store.Obra',
        'GrupoBruce.store.Periocidad',
        'GrupoBruce.store.PeriodoPlanilla',
        'GrupoBruce.store.PeriodoVacacion',
        'GrupoBruce.store.Planilla',
        'GrupoBruce.store.PlanillaTareo',
        'GrupoBruce.store.Plantilla',
        'GrupoBruce.store.Prestamo',
        'GrupoBruce.store.PrestamoPago',
        'GrupoBruce.store.Proceso',
        'GrupoBruce.store.Proforma',
        'GrupoBruce.store.ProformaDetalle',
        'GrupoBruce.store.RegimenPensionario',
        'GrupoBruce.store.Rol',
        'GrupoBruce.store.Sucursal',
        'GrupoBruce.store.Textralaboral',
        'GrupoBruce.store.TiempoAusencia',
        'GrupoBruce.store.TiempoContrato',
        'GrupoBruce.store.TipoAusencia',
        'GrupoBruce.store.TipoConcepto',
        'GrupoBruce.store.TipoContrato',
        'GrupoBruce.store.TipoDocumento',
        'GrupoBruce.store.TipoEquipo',
        'GrupoBruce.store.TipoEstudio',
        'GrupoBruce.store.TipoFormacion',
        'GrupoBruce.store.TipoMantenimiento',
        'GrupoBruce.store.TipoPlanilla',
        'GrupoBruce.store.TipoTextra',
        'GrupoBruce.store.TipoTrabajador',
        'GrupoBruce.store.TipoVacacion',
        'GrupoBruce.store.TipoVariable',
        'GrupoBruce.store.Trabajador',
        'GrupoBruce.store.Turno',
        'GrupoBruce.store.UnidadMedida',
        'GrupoBruce.store.Usuario',
        'Grupobruce.store.Vacacion'
    ],

    launch: function () {
        var loggedIn = Ext.decode(localStorage.getItem("sesionEstado"));
               
        Ext.ux.ActivityMonitor.init({
            verbose: true
        });

        Ext.ux.ActivityMonitor.start();

        Ext.ux.ActivityMonitor.isInactive = function () {
//            Ext.Msg.alert('Monitor', 'User is inactive!');
            localStorage.removeItem('sesionEstado');
            localStorage.removeItem('sesionUsuario');
            location.reload(true);
        };

        Ext.ux.ActivityMonitor.isActive = function () {
//            Ext.Msg.alert('Monitor', 'User is active!');
        };

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