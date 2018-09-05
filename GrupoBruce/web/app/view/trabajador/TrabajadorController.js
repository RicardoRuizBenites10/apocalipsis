Ext.define('GrupoBruce.view.trabajador.TrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctrabajador',

    onItemSelected: function (sender, record, item, index) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
//        Ext.Msg.alert("Test select", record.getData());
//        Ext.Msg.alert("Prueba", Ext.encode(record.getData()));
    },

    nuevoTrabajador: function () {
        Ext.Msg.alert('Alerta', 'Nuevo trabajador.');
    },

    editarTrabajador: function () {
        var grid = this.lookupReference('gridTrabajador');
        var trabajadorModel = grid.getSelection()[0];

        var formT = new GrupoBruce.view.trabajador.TrabajadorForm();
        formT.loadRecord(trabajadorModel);

        var formP = new GrupoBruce.view.trabajador.PersonaForm();
        formP.loadRecord(trabajadorModel.getPersona());

        var window = new Ext.window.Window({
            title: 'EDITAR TRABAJADOR',
            
            width: 560,
            modal: true,
            closable: false,
            
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
                            title: 'Nivel educacional',
                            iconCls: 'fa fa-mortar-board'
                        }, {
                            title: 'Datos laborales',
                            iconCls: 'fa fa-file-text',
                            items: [
                                formT
                            ]
                        }]
                }],
            
            buttons: [{
                    text: 'CANCELAR'
                }, {
                    text: 'GRABAR'
                }]
        });

        window.show();
    },

    verTrabajador: function () {
        
    }

});
