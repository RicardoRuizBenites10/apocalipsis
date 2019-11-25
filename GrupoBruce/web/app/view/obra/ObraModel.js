Ext.define('GrupoBruce.view.obra.ObraModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobra',
    data: {
        selectObra: null,
        currentDate: new Date()
    },

    stores: {
        obratipos: {
            type: 'Sobratipo',
            autoLoad: true
        },
        proformas: {
            type: 'Sproforma',
            autoLoad: true
        }
    },
    
    formulas: {
        currentYear : function(get){
            var fecha = new Date();
            var ano = (fecha.getFullYear()).toString().substr(2);
            return ano;
        }
    }

});
