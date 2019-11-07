Ext.define('GrupoBruce.view.especificacionactividad.EspecificacionActividadController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cespecificacionactividad',

    createDialog: function (record) {
        var window = new GrupoBruce.view.especificacionactividad.FormEspecificacionActividad();
        var vmGrid = Ext.getCmp('id_wespecificacionactividad').getViewModel();
        if (!record) {
            window.setTitle('Agregar actividad');
            record = new GrupoBruce.model.EspecificacionActividad();
            record.set('idEspecificacion', vmGrid.get('recordEspecificacion').get('idEspecificacion'));
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addEspecificacionActividad: function () {
        this.createDialog(null);
    },

    editEspecificacionActividad: function () {
        var model = this.getViewModel().get('selectEspecificacionActividad');
        this.createDialog(model);
    },

    onSaveEspecificacionActividad: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wespecificacionactividad');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            var store = grid.getStore();
            form.updateRecord(model); // update the record with the form data
            model.set('actividad', window.getViewModel().get('selectActividad').get('nombre'));
            model.set('etapa', window.getViewModel().get('selectActividad').get('etapa'));
            model.set('fecha', new Date());
            store.add(model);
            
            var removedRecords = store.getRemovedRecords();
            removedRecords.forEach(function (item, index) {
                if (model.get('idActividad') === item.get('idActividad')) {
                    removedRecords.splice(index, 1);
                }
            });
            store.removed = removedRecords;
            
            form.reset();
            window.destroy();
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.');
        }
    },

    deleteEspecificacionActividad: function () {
        var grid = Ext.getCmp('id_wespecificacionactividad');
        var model = grid.getSelection()[0];
        grid.getStore().remove(model);
    },

    selectPicker: function (picker, record) {
        var codigos = [];
        codigos.push(record.get('idEproceso'));
        this.childsString(record, codigos);
        picker.up('window').getViewModel().set('etapas',codigos.toString());
    },

    childsString: function (record, codigos) {
        var childs = record.childNodes;
        if (childs.length === 0) {
            codigos.push(record.get('idEproceso'));
        } else {
            for (var i = 0; i < childs.length; i++) {
                this.childsString(childs[i], codigos);
            }
        }
    }


});
