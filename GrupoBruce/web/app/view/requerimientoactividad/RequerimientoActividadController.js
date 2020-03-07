Ext.define('GrupoBruce.view.requerimientoactividad.RequerimientoActividadController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Crequerimientoactividad',

    createWindow: function (view) {
        var grid = this.lookupReference('list_requerimientoactividad');
        var selectmodel = grid.getSelection()[0];
        var window = Ext.create(view);

        var vm = this.getViewModel();
        var trabajador = vm.get('selectTrabajador');
        var obra = vm.get('recordObra');
        var requerimiento = Ext.create('GrupoBruce.model.Requerimiento', {
            idRequerimiento: selectmodel.get('idRequerimiento'),
            idEspecificacion: selectmodel.get('idEspecificacion'),
            idActividad: selectmodel.get('idActividad'),
            fechaProgramado: vm.get('fechaProgramado'),
            idObra: obra.get('idObra'),
            idTrabajador: trabajador.get('idTrabajador'),
            obra: obra.get('nombre'),
            actividad: selectmodel.get('actividad'),
            trabajador: trabajador.get('nombresCompletos')
        });
        window.getViewModel().set('recordRequerimiento', requerimiento);
//        window.getViewModel().set('selectEtapaProceso_id', selectmodel.get('idEproceso'));
    },

    onGenerarRequerimientos: function () {
        this.createWindow('GrupoBruce.view.requerimientomaterial.RequerimientoMaterial');
    }

});
