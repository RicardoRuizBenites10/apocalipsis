Ext.define('GrupoBruce.view.contrato.FormContratoTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.wformContratoTrabajador',
    reference: 'form_contratoTrabajador',

    viewModel: {
        type: 'VMcontratoTrabajador'
    },
    controller: 'CcontratoTrabajador',

    autoShow: true,
    height: 400,
    width: 600,
    closable: true,
    resizable: false,
    modal: true,

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
//                            name: 'idTrabajador',
                            bind:{
                                value: '{thisTrabajador}'
                            },
                            fieldLabel: 'Documento'
                        }]
                }, {
                    items: [{
                            xtype: 'combobox',
                            name: 'idTcontrato',
                            fieldLabel: 'Tipo contrato:'
                        }, {
                            xtype: 'combobox',
                            name: 'idEcontrato',
                            fieldLabel: 'Estado contrato:'
                        }]
                }, {
                    items: [{
                            xtype: 'datefield',
                            name: 'fechaInicio',
                            fieldLabel: 'Inicio contrato:',
                            format: 'd/m/Y'
                        }]
                }]

        }]


});
