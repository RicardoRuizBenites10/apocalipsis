Ext.define('GrupoBruce.view.etapaproceso.FormEtapaProceso', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformetapaproceso',
    reference: 'form_etapaproceso',
    id: 'id_wformetapaproceso',

    controller: 'Cetapaproceso',
    viewModel: {
        type: 'VMetapaproceso'
    },
    
    dialog: true,
    resizable: false,
    closable: false,
    width: 350,
    title: 'Eidtar área de producción',

    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    allowBlank: false,
                    padding: 5
                }
            },

            items: [{
                    items: [{
                            xtype: 'textfield',
                            name: 'descripcion',
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                }, {
                    flex: 2,
                    items: [{
                            xtype: 'numberfield',
                            name: 'orden',
                            fieldLabel: 'Número de orden',
                            hideTrigger: true,
                            minValue: 0,
                            width: '49%'
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'pasaBus',
                            reference: 'chk_pasabus',
                            fieldLabel: 'Área de trabajo',
                            boxLabel: 'Pasa O.P.',
                            flex: 1
                        }, {
                            xtype: 'checkbox',
                            name: 'situacion',
                            reference: 'chk_situacionetapaproceso',
                            fieldLabel: 'Situación',
                            boxLabel: 'Activo',
                            flex: 1
                        }]
                }],

            buttons: [{
                    text: 'Cancelar',
                    listeners: {
                        click: function () {
                            this.up('form').reset();
                            this.up('window').close();
                        }
                    }
                }, {
                    text: 'Restablecer',
                    listeners: {
                        click: function () {
                            this.up('form').reset();
                        }
                    }
                }, {
                    text: 'Grabar',
                    iconCls: 'fa fa-save',
                    formBind: true,
                    listeners: {
                        click: 'onSaveEtapaProceso'
                    }
                }]
        }]

});