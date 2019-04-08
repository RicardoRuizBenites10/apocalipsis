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
        var storePtareo = grid.getStore();
        var viewmodel = this.getViewModel();
        var storeCAsignados = viewmodel.get('conceptosAsignado');
        var tipoTrabajador = viewmodel.get('selectTipoTrabajador');
        var periodoPlanilla = viewmodel.get('selectPeriodoPlanilla');
        var storeComisionrp = viewmodel.get('comisionsrp');

        var HABER_BASICO, PRP_DIAS_PER, PRP_DIAS_DOM, PRP_DIAS_TRAB, NUM_H_EXTRA25, NUM_H_EXTRA35, NUM_H_EXTRA100, MOVILIDAD, REINTEGRO, RPREGIMEN, RPCOMISION, DEVOLUCION, EMP_RMV, DIAS_PLAME, ADELANTO, NUM_H_DESCT, PRESTAMO, OTROS_DESCT, RP_PENSION, RP_SEGURO, RP_COMISION, RP_FONDO, FLAG_ASIG_FAM;
        var xpro = true;

        var storePlanilla = Ext.create('GrupoBruce.store.Planilla');
        var planilla;

        storePtareo.each(function (item) {
            if (item.get('procesado')) {
                xpro = false;
            }
            item.set('procesado', true);
        });
        if (xpro) {
            storePtareo.each(function (item) {
                ADELANTO = item.get('adelanto');
                DEVOLUCION = item.get('devolucion');
                PRP_DIAS_PER = item.get('diasPeriodo');
                PRP_DIAS_DOM = item.get('diasDominical');
                DIAS_PLAME = item.get('diasPlame');
                PRP_DIAS_TRAB = item.get('diasTrabajado');
                EMP_RMV = item.get('empRmv');
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
                RPREGIMEN = item.get('rpregimen');
                RPCOMISION = item.get('rpcomision');

                var comision = storeComisionrp.findRecord('idComisionrp', RPCOMISION);
                RP_PENSION = RPREGIMEN === '' ? 0 : (RPCOMISION === 0 ? tipoTrabajador.get('pension') / 100 : 0); // tipoTrabajador.get('pension') / 100;
                RP_FONDO = RPREGIMEN === '' ? 0 : (RPCOMISION !== 0 ? comision.get('fondo') / 100 : 0);
                RP_SEGURO = RPREGIMEN === '' ? 0 : (RPCOMISION !== 0 ? comision.get('seguro') / 100 : 0);
                RP_COMISION = RPREGIMEN === '' ? 0 : (RPCOMISION !== 0 ? comision.get('comision') / 100 : 0);

                storeCAsignados.each(function (concepto) {
                    eval(concepto.get('idConcepto') + ' = ' + eval(concepto.get("formula")) + ';');
                    planilla = new GrupoBruce.model.Planilla();
                    planilla.set('idTrabajador', item.get('idTrabajador'));
                    planilla.set('idPplanilla', periodoPlanilla.get('idPplanilla'));
                    planilla.set('idTtrabajador', concepto.get('idTtrabajador'));
                    planilla.set('idTplanilla', concepto.get('idTplanilla'));
                    planilla.set('idConcepto', concepto.get('idConcepto'));
                    planilla.set('descripcion', concepto.get('descripcion'));
                    planilla.set('importe', eval(concepto.get('idConcepto')));
                    planilla.set('fecha', new Date());
                    storePlanilla.add(planilla);
                });

            });
            storePlanilla.sync({
                success: function (response, operation) {
                    storePtareo.sync({
                        success: function (response, operation) {
                            grid.getStore().reload();
                            Ext.Msg.alert('Success', 'Operación exitosa.');
                        },
                        failure: function (response, operation) {
                            Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                        }
                    });
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                }
            });
        } else {
            Ext.MessageBox.show({
                title: 'Error',
                msg: 'Los datos ya estan procesados.',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.ERROR
            });
        }
    },

    onPrintCuadro: function (btn) {
        var viewmodel = this.getViewModel();
        var periodo = viewmodel.get('selectPeriodoPlanilla');

        var mod = new Ext.Window({
            title: 'Reporte',
            width: 600,
            height: 500,
            modal: true,
            items: [{
                    xtype: 'component',
                    autoEl: {
                        tag: 'iframe',
                        style: 'height: 100%; width: 100%; border: none',
                        src: 'ReportCPlanilla?' + 'idPplanilla=' + periodo.get('idPplanilla')
                    }
                }]
        }).show();


//        Ext.Ajax.request({
//            url: 'reportCPlanilla',
//            method: 'POST',
//            isUpload: true,
//            autoAbort: false,
//            headers: {
//                'Content-Disposition' : 'attachment'
//            },
//            params: {
//                idPplanilla: periodo.get('idPplanilla')
//            },
//            success: function (response, opts) {
//                console.log(response);
////                if (result.status === 204) {
////                    Ext.Msg.alert('Empty Report', 'There is no data');
////                } else if (result.status === 200) {
////                    var win = window.open('', '_blank');
////                    win.location = 'reportCPlanilla?'+ 'idPplanilla='+periodo.get('idPplanilla');
////                    win.focus();
////                }
//            },
//            failurer: function (response, opts) {
//                Ext.Msg.alert('Status', response.status);
//            }
//        });

    }
});
