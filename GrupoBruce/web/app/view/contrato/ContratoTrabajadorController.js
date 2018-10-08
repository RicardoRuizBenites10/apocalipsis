Ext.define('GrupoBruce.view.contrato.ContratoTrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.CcontratoTrabajador',
    
    createDialog: function(record) {
        var view = this.getView();

        this.isEdit = !!record;
        this.dialog = view.add({
            xtype: 'WformContratoTrabajador',
            viewModel: {
                data: {
                    title: record ? 'Editar contrato ' : 'Nuevo contrato'
                },
                links: {
                    theContrato: record || {
                        type: 'GrupoBruce.model.ContratoTrabajador',
                        create: true
                    }
                }
            }
        });
        this.dialog.show();
    },
    
    addContrato: function () {
        this.createDialog(null);
    },
    
    editContrato: function(){
        var grid = this.lookupReference('list_contratoTrabajador');
        this.createDialog(grid.getSelection()[0]);
    }

});
