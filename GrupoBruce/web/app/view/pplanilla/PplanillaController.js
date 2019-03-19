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
                MOVILIDAD, REINTEGRO, DEVOLUCION, EMP_RMV, DIAS_PLAME, ADELANTO, NUM_H_DESCT, PRESTAMO,
                OTROS_DESCT, PENSION, FLAG_AFP, FLAG_ASIG_FAM;
        var xpro = true, numCon = 0;
        store.each(function (item) {
            if (item.get('procesado')) {
                xpro = false;
            }
        });
        if (xpro) {
            store.each(function (item) {

                ADELANTO = item.get('adelanto');
                DEVOLUCION = item.get('devolucion');
                PRP_DIAS_PER = item.get('diasPeriodo');
                DIAS_PLAME = item.get('diasPlame');
                PRP_DIAS_TRAB = item.get('diasTrabajado');
                EMP_RMV = item.get('empRmv');
                FLAG_AFP = item.get('flagAfp');
                FLAG_ASIG_FAM = item.get('flagAsig');
                HABER_BASICO = item.get('haberBasico');
                NUM_H_EXTRA25 = item.get('hextra25');
                NUM_H_EXTRA35 = item.get('hextra35');
                NUM_H_EXTRA100 = item.get('hextra35');
                NUM_H_DESCT = item.get('horasDesct');
                MOVILIDAD = item.get('movilidad');
                OTROS_DESCT = item.get('otrosDesct');
                PRESTAMO = item.get('prestamo');
                REINTEGRO = item.get('reintegro');

                PENSION = tipoTrabajador.get('pension') / 100;
                var dodo = this;
                storeConceptos.each(function (concepto) {
                    numCon = numCon + 1;
////                    var define = 'if(!' + concepto.get('idConcepto') + '){ var ' + concepto.get('idConcepto') + ' = ' + eval(concepto.get("formula")) + ';}';
////                    eval(define);
////                    console.log('dada : ' + eval('F_JORNAL_BASICO'));
//////                    var evalua = 'console.log("' + concepto.get('idConcepto') + ' :" + ' + concepto.get("formula") + ' );';
//////                    eval(evalua);
//////                    console.log('Concepto ' + numCon + ' | ' + concepto.get('idConcepto') + ': ' + eval(concepto.get('idConcepto')));
                    var define;
                    if (numCon < 5) {
                        define = "if(!dodo.numero" + numCon + "){  dodo.numero" + numCon + "=" + numCon * 5 + ";}";
                    } else {
                        define = "if(!dodo.numero" + numCon + "){  dodo.numero" + numCon + "=" + (numCon * 5 + this.numero1 + this.numero2) + ";}";
                    }
                    console.log('Dentro y antes de eval Número: ' + numCon);
                    eval(define);
                    console.log('Dentro y despues de eval :' + dodo.numero1);
                }, dodo);
                console.log('Fuera de each: ' + dodo.numero5);
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
