Ext.define('GrupoBruce.view.asistencia.AsistenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casistencia',

    createDialog: function (record) {
        var window = new GrupoBruce.view.asistencia.ListMarcas();
        if (!record) {
            record = Ext.create('GrupoBruce.model.Archivo');
        }
        window.down('form').loadRecord(record);
    },

    onImportacionMarcas: function () {
        this.createDialog(null);
    },

    onImportacionFile: function (btn) {
        var form = btn.up('form');
        var model = form.getRecord();

        var file = form.down('filefield').dom.files[0];

        if (file !== null) {
            var reader = new FileReader();
            reader.readAsArrayBuffer(file);
            reader.onload = function (e) {
                alert(e.target.result);
            };


//            var reader = new FileReader();
//            reader.onload = function (e) {
//                $img_avatar.data({"avatarB64": e.target.result, "avatarNombre": avatar_name});
//                $img_avatar.attr({src: e.target.result, title: avatar_name});
//            };
//            reader.readAsDataURL(this.files[0]);
        }

        console.log('Mi archivo: ' + file.getReference());

    }

});
