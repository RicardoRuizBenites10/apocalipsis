Ext.define('GrupoBruce.view.vacacion.VacacionTrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.CvacacionTrabajador',
    
    createDialog: function(record){
        var view = this.getView();

        this.dialog = view.add({
            xtype: 'WformVacacionTrabajador',
            viewModel: {
                data: {
                    title: record ? 'Editar vacación ' : 'Registrar vacación'
                }
            }
        });
        if (record) {
            this.dialog.down('form').loadRecord(record);
        } else {
            var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
            var newcontrato = Ext.create('GrupoBruce.model.Vacacion', {
                idTrabajador: idTrabajador
            });
            this.dialog.down('form').loadRecord(newcontrato);
        }
        this.dialog.show();
    },
    
    addVacacion: function(){
        this.createDialog(null);
    }

});
