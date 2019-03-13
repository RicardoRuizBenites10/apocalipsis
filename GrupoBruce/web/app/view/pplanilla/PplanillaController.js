Ext.define('GrupoBruce.view.pplanilla.PplanillaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cpplanilla',

    onAprobar: function (btn) {
        var grid = btn.up('WlistPplanilla');
        var store = grid.getStore();
        var xapro = true;

        store.each(function (item) {
            if (item.get('aprobado')) {
                xapro = false;
            }
        });
        if (xapro) {
            store.each(function (item) {
                item.set('aprobado', true);
            });
            store.sync({
                success: function (response, operation) {
                    grid.getStore().reload();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                }
            });
        } else {
            Ext.MessageBox.show({
                title: 'Error',
                msg: 'Los datos ya estan aprobados.',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.ERROR
            });
        }

    },

    onProcesar: function (btn) {
        var grid = btn.up('WlistPplanilla');
        var store = grid.getStore();
        var storeConceptos = this.getViewModel().get('conceptos');
        var tipoTrabajador = this.getViewModel().get('selectTipoTrabajador');
        var HABER_BASICO, PRP_DIAS_PER, PRP_DIAS_TRAB, NUM_H_EXTRA25, NUM_H_EXTRA35, NUM_H_EXTRA100,
                MOVILIDAD, REINTEGRO, DEVOLUCION, DIAS_VAC, EMP_RMV, DIAS_PLAME;
        var NUM_H_DESCT, NUM_M_DESCT, PRESTAMO, OTROS_DESCT;
        var REMUN_AFECTA = 0, PRP_FAMILIAR = 0;
        var PENSION, FLAG_AFP, FLAG_ASIG_FAM;
        var xpro = true, numCon = 0;
        store.each(function (item) {
            if (item.get('procesado')) {
                xpro = false;
            }
        });
        if (xpro) {
            store.each(function (item) {

                HABER_BASICO = item.get('haberBasico');
                PRP_DIAS_PER = item.get('diasPeriodo');
                PRP_DIAS_TRAB = item.get('diasTrabajado');
                DIAS_VAC = 0;
                MOVILIDAD = item.get('movilidad');
                REINTEGRO = item.get('reintegro');
                DEVOLUCION = item.get('devolucion');
                EMP_RMV = item.get('empRmv');
                DIAS_PLAME = item.get('diasPlame');
                NUM_H_EXTRA25 = item.get('hextra25');
                NUM_H_EXTRA35 = item.get('hextra35');
                NUM_H_EXTRA100 = item.get('hextra35');
                NUM_H_DESCT = item.get('horasDesct');
                NUM_M_DESCT = 0;
                PRESTAMO = item.get('prestamo');
                OTROS_DESCT = item.get('otrosDesct');

                PENSION = tipoTrabajador.get('pension') / 100;
                FLAG_AFP = item.get('flagAfp');
                FLAG_ASIG_FAM = item.get('flagAsig');

                storeConceptos.each(function (concepto) {
                    numCon = numCon + 1;
                    console.log('Concepto ' + concepto.get('idConcepto') + ': ' + eval(concepto.get('formula')));
                });
            });
        } else {
            Ext.MessageBox.show({
                title: 'Error',
                msg: 'Los datos ya estan aprobados.',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.ERROR
            });
        }
    }

});
