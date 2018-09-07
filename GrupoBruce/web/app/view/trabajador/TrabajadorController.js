Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    onItemSelected: function (sender, record, item, index) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
//        Ext.Msg.alert("Prueba", Ext.encode(record.getData(true)));
    },

    nuevoTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Nuevo trabajador.');
    },

    editarTrabajador: function () {
        var grid = this.lookupReference('gridTrabajador');
        var trabajadorModel = grid.getSelection()[0];

        var formP = new GrupoBruce.view.trabajador.PersonaForm();
        formP.loadRecord(trabajadorModel);

        var formT = new GrupoBruce.view.trabajador.TrabajadorForm();
        formT.loadRecord(trabajadorModel);

        var window = new Ext.window.Window({
            title: 'EDITAR TRABAJADOR',

            width: 560,
            modal: true,
            closable: false,
            resizable: false,

            items: [{
                    xtype: 'tabpanel',
                    border: false,
                    defaults: {
                        bodyPadding: 10,
                        scrollable: true,
                        border: false
                    },
                    items: [{
                            title: 'Información personal',
                            iconCls: 'fa fa-user',
                            items: [
                                formP
                            ]
                        }, {
                            title: 'Datos laborales',
                            iconCls: 'fa fa-file-text',
                            items: [
                                formT
                            ]
                        }, {
                            title: 'Nivel educacional',
                            iconCls: 'fa fa-mortar-board',
                            items: [

                            ]
                        }]
                }],

            buttons: [{
                    text: 'CANCELAR'
                }, {
                    text: 'GRABAR',
                    listeners: {
                        click: function(){
//                            var formPersona = this.lookupReference('form_persona');
                            var data = formP.getForm().getValues();
                            Ext.Msg.alert('Titulo', 'Info: '+Ext.JSON.encodeValue(data, '\n'));
                        }
                    }
                }]
        });

        window.show();
    },

    verTrabajador: function () {

    }

});
