Ext.define('GrupoBruce.view.obraseguimiento.ObraSeguimientoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cobraseguimiento',

    onSaveObraSeguimiento: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistobra');
        var windowVM2 = window.getViewModel();
        var store2 = windowVM2.get('obraseguimientos');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            //console.log(usamat);
            var ubiVeri = true;
            store2.each(function (item) {
                item.set('idObra', model.get('idObra'));
                if (item.get('ubicacion')) {
                    model.set('idEproceso',item.get('idEproceso'));
                    ubiVeri = item.get('inicioProgramado') && item.get('finProgramado');
                }
            });
            if (!ubiVeri) {
                Ext.Msg.show({
                    title: 'Datos invalidos',
                    msg: 'Por favor ingrese inicio y fin programado para la ubicacion actual de la OP.',
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
                return false;
            }
            model.save({// save the record to the server
                success: function (model, operation) {
                    if (store2.needsSync !== undefined && store2.needsSync) {
                        store2.sync({
                            success: function (response, operation) {
                                grid.getStore().reload();
                                form.reset();
                                window.destroy();
                                Ext.Msg.alert('Success', 'Operación exitosa.');
                            },
                            failure: function (batch, operation) {
                                var msg = '';
                                if (batch.hasException) {
                                    for (var i = 0; i < batch.exceptions.length; i++) {
                                        switch (batch.exceptions[i].action) {
                                            case "destroy" :
                                                msg = msg + batch.exceptions[i]._records.length + " Delete, ";
                                                break;
                                            case "update" :
                                                msg = msg + batch.exceptions[i]._records.length + " Update, ";
                                                break;
                                            case "create" :
                                                msg = msg + batch.exceptions[i]._records.length + " Create, ";
                                                break;
                                        }
                                    }
                                    Ext.Msg.alert("Status", msg + " operation failed!");
                                } else
                                    Ext.Msg.alert('Status', 'Changes failed.');
                            }
                        });
                    } else {
                        grid.getStore().reload();
                        form.reset();
                        window.destroy();
                        Ext.Msg.alert('Success', 'Operación exitosa.');
                    }
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.',)
        }
    },

    onSelectionChange: function (iView, iCellEl, iColIdx, iRecord, iRowEl, iRowIdx, iEvent) {
        if (iColIdx === 5) {
            var actual = iRecord.get('ubicacion'), idEtapa = iRecord.get('idEproceso');
            if (actual) {
                var grid = iView.up('grid');
                var store = grid.getStore();
                var ini, fin;
                var jsonData = [];

                store.each(function (item) {
                    if (item.get('idEproceso') !== idEtapa) {
                        item.set('ubicacion', !actual);
                    } else {
                        ini = item.get('inicioProgramado');
                        fin = item.get('finProgramado');
                        if (!ini) {
                            item.set('inicioProgramado', new Date());
                        }
                        if (!fin) {
                            item.set('finProgramado', ini ? ini : new Date());
                        }
                    }
                    jsonData.push(item.data);
                });
            } else {
                iRecord.set('ubicacion', true);
            }
        }
    }

});
