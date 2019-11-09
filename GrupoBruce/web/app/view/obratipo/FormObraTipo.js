Ext.define('GrupoBruce.view.obratipo.FormObraTipo', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformobratipo',
    reference: 'form_obratipo',
    id: 'id_wformobratipo',

    controller: 'Cobratipo',
    viewModel: {
        type: 'VMobratipo'
    },

    modal: true,
    autoShow: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar tipo orden de producción',
    items: [{
            xtype: 'form',
            padding: 7,
            defaults: {
                allowBlank: false,
                labelAlign: 'top'
            },
            items: [{
                    xtype: 'textfield',
                    name: 'idObrtip',
                    fieldLabel: 'Código',
                    bind: {
                        readOnly: '{!newRecord}'
                    },
                    listeners: {
                        change: function (textfield, newValue, oldValue) {
                            console.log(newValue);
                            textfield.up('window').getViewModel().set('currentCodigo', newValue);
                        }
                    }
                }, {
                    xtype: 'textarea',
                    name: 'descripcion',
                    fieldLabel: 'Descripción',
                    width: '100%'
                }, {
                    xtype: 'checkbox',
                    reference: 'chk_situacionobratipo',
                    name: 'situacion',
                    fieldLabel: 'Situación',
                    boxLabel: 'Activo'
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
                        click: 'onSaveObraTipo'
                    }
                }]
        }]
});