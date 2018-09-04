Ext.define('GrupoBruce.view.trabajador.PersonaForm', {
    extend: 'Ext.form.Panel',

    xtype: 'personaForm',
    reference: 'form_persona',

    height: 435,
    scrollable: true,

    defaults: {
        xtype: 'container',
        layout: 'hbox',
        defaults: {
            allowBlank: false,
            labelAlign: 'top',
            padding: 5,
            flex: 1
        }
    },
    items: [{

            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Nacionalidad:',
                    displayField: 'descripcion',
                    valueField: 'idNacionalidad',
                    store: {
                        type: 'Snacionalidad',
                        autoLoad: true
                    }
                }, {
                    xtype: 'combobox',
                    fieldLabel: 'Tipo documento:',
                    displayField: 'descripcion',
                    valueField: 'idTdocumento',
                    store: {
                        type: 'StipoDocumento',
                        autoLoad: true
                    }
                }, {
                    xtype: 'textfield',
                    name: 'dni',
                    fieldLabel: 'Número DNI:'
                }]
        }, {
            items: [
                {
                    xtype: 'textfield',
                    name: 'apPaterno',
                    fieldLabel: 'Apellido Paterno'
                }, {
                    xtype: 'textfield',
                    name: 'apMaterno',
                    fieldLabel: 'Apellido Materno'
                }, {
                    xtype: 'textfield',
                    name: 'nombres',
                    fieldLabel: 'Nombres'
                }
            ]
        }, {
            items: [
                {
                    xtype: 'combobox',
                    name: 'apMaterno',
                    fieldLabel: 'Genero :'
                    
                }, {
                    xtype: 'datefield',
                    name: 'nacimiento',
                    fieldLabel: 'Fecha nacimiento :'
                }, {
                    xtype: 'combobox',
                    name: 'apPaterno',
                    fieldLabel: 'Estado civil :'
                }
            ]
        }, {
            items: [
                {
                    xtype: 'numberfield',
                    allowDecimals: false,
                    hideTrigger: true,
                    minValue: 0,
                    maxValue: 8,
                    name: 'nroHijos',
                    fieldLabel: 'Número hijos :'
                }, {
                    xtype: 'textfield',
                    name: 'telefono',
                    fieldLabel: 'Teléfono :'
                }
            ]
        }, {
            items: [{
                    xtype: 'textfield',
                    name: 'referencia',
                    fieldLabel: 'Referencia :'
                }]
        }, {
            items: [{
                    xtype: 'textfield',
                    name: 'direccion',
                    fieldLabel: 'Dirección :'
                }]
        }]
});
