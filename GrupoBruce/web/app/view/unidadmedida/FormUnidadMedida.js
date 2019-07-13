Ext.define('GrupoBruce.view.unidadmedida.FormUnidadMedida', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformunidadmedida',
    reference: 'form_unidadmedida',

    controller: 'Cunidadmedida',
    viewModel: {
        type: 'VMunidadmedida'
    },

    closable: false,
    resizable: false,
    modal: true,
    width: 350,
    title: 'Editar unidad de medida',

    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 5
                }
            },

            items: [{
                    items: [{
                            xtype: 'textfield',
                            name: 'idUmedida',
                            fieldLabel: 'Código',
                            bind: {
                                editable: '{newRegister}'
                            },
                            width: '48%'
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'denominacion',
                            fieldLabel: 'Descripción',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'numberfield',
                            name: 'equivalencia',
                            fieldLabel: 'Equivalencia',
                            hideTrigger: true,
                            flex: 1
                        },{
                            xtype: 'checkbox',
                            name: 'situacion',
                            reference: 'chk_situacionunidadmedida',
                            boxLabel: 'Activo',
                            fieldLabel: 'Situación',
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
                        click: 'onSaveUnidadMedida'
                    }
                }]
        }]
});