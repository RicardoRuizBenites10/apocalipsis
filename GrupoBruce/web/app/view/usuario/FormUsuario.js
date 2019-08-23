Ext.define('GrupoBruce.view.usuario.FormUsuario', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformUsuario',
    reference: 'form_usuario',

    controller: 'Cusuario',
    viewModel: {
        type: 'VMusuario'
    },

    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,
    width: 400,

    title: 'Editar usuario',
    items: [{
            xtype: 'form',

            items: [{
                    xtype: 'tabpanel',
                    border: false,
                    defaults: {
                        bodyPadding: 4,
                        scrollable: true,
                        border: false,
                        defaults: {
                            xtype: 'container',
                            layout: 'hbox',
                            defaults: {
                                allowBlank: false,
                                labelAlign: 'top',
                                padding: 5
                            }
                        }
                    },
                    items: [{
                            title: 'Infomación general',
                            items: [{
                                    items: [{
                                            xtype: 'combo',
                                            id: 'id_trabajadorUsuario',
                                            name: 'idUsuario',
                                            displayField: 'nombres',
                                            valueField: 'idTrabajador',
                                            fieldLabel: 'Trabajador',
                                            emptyText: 'Buscar..',
                                            bind: {
                                                store: '{trabajadors}',
                                                selection: '{selectTrabajador}'
                                            },
                                            tpl: [
                                                '<ul class="x-list-plain">',
                                                '<tpl for=".">',
                                                '<li class="',
                                                Ext.baseCSSPrefix, 'grid-group-hd ', Ext.baseCSSPrefix, 'grid-group-title">DNI : {idTrabajador}</li>',
                                                '<li class="x-boundlist-item">',
                                                '{nombresCompletos} ',
                                                '</li>',
                                                '</tpl>',
                                                '</ul>'
                                            ],
                                            minChars: 3,
                                            pageSize: true,
                                            hideTrigger: true,
                                            triggerAction: 'query',
                                            width: 380
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'combobox',
                                            name: 'idRol',
                                            fieldLabel: 'Rol',
                                            editable: false,
                                            emptyText: 'Seleccionar',
                                            displayField: 'denominacion',
                                            valueField: 'idRol',
                                            bind: {
                                                store: '{rols}'
                                            },
                                            width: 380
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'textfield',
                                            name: 'usu',
                                            fieldLabel: 'Usuario',
                                            editable: false,
                                            bind: '{selectTrabajador ? selectTrabajador.idTrabajador : ""}',
                                            width: 185
                                        }, {
                                            xtype: 'checkbox',
                                            reference: 'estado_usuario',
                                            name: 'estado',
                                            fieldLabel: 'Estado',
                                            boxLabel: 'Activo'
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'fieldcontainer',
                                            fieldLabel: 'Password',
                                            layout: 'hbox',
                                            items: [{
                                                    xtype: 'textfield',
                                                    name: 'deClave',
                                                    inputType: 'password',
                                                    width: 350
                                                }, {
                                                    xtype: 'button',
                                                    iconCls: 'fa fa-eye',
                                                    tooltip: 'Mostrar',
                                                    enableToggle: true,
                                                    toggleHandler: function (button, pressed) {
                                                        this.setTooltip(pressed ? 'Ocultar' : 'Mostrar');
                                                        this.setIconCls(pressed ? 'fa fa-eye-slash' : 'fa fa-eye');
                                                        this.prev().getEl().selectNode('input', false).set({'type': pressed ? 'text' : 'password'});
                                                    }
                                                }]
                                        }]
                                }]
                        }, {
                            title: 'Permisos',
                            iconCls: 'x-fa fa-check-square-o',
                            items: [{
                                    items: [{
                                            xtype: 'combobox',
                                            fieldLabel: 'Acceso a empresa',
                                            name: 'idEmpresa',
                                            displayField: 'descripcion',
                                            valueField: 'idEmpresa',
                                            bind: {
                                                store: '{empresas}',
                                                selection: '{selectEmpresa}'
                                            },
                                            editable: false,
                                            emptyText: 'Seleccionar',
                                            flex: 1

                                        }]
                                }, {
                                    items: [{
                                            xtype: 'tagfield',
                                            fieldLabel: 'Acceso a sucursales',
                                            name: 'accSucursal',
                                            displayField: 'descripcion',
                                            valueField: 'idSucursal',
                                            bind: {
                                                store: '{acc_sucursals}',
                                                selection: '{selectAccsucursal}'
                                            },
                                            reference: 'tag_sucursals',
                                            publishes: 'value',
                                            emptyText: 'Seleccionar',
                                            forceSelection: true,
                                            flex: 1
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'combo',
                                            fieldLabel: 'Sucursal por defecto',
                                            name: 'idSucursal',
                                            displayField: 'descripcion',
                                            valueField: 'idSucursal',
                                            bind: {
                                                store: '{def_sucursal}'
                                            },
                                            emptyText: 'Seleccionar',
                                            forceSelection: true,
                                            editable: false,
                                            flex: 1
                                        }]
                                }]
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
                        click: 'onSaveUsuario'
                    }
                }]
        }]
});