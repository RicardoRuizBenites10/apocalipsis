Ext.define('GrupoBruce.view.main.MainMenu', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.Wmainmenu',
    reference: 'main_menu',
    id: 'id_wmainmenu',

    width: 240,
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    cls: 'treelist-with-nav',

    items: [{
            xtype: 'container',
            reference: 'tarjeta',
            style: 'background-color: #f7f7f7 !important;padding: 10px;border-bottom:1px solid rgba(0, 0, 0, 0.1) !important;',
            height: 92,
            bodyPadding: 10,
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            items: [{
                    xtype: 'image',
                    style: 'border: 4px solid #f2f2f2; border-radius: 50%;',
                    height: 80,
                    bind: {
                        src: '{thisAvatar}',
                        alt: '{altAvatar}'
                    },
                    flex: 1
                }, {
                    xtype: 'container',
                    style: 'padding: 10px',
                    flex: 2,
                    bind: {
                        html: ' Bienvenido,  <br> <b>{thisName}</b>'
                    }
                }]
        }, {
            items: [{
                    xtype: 'treelist',
                    reference: 'treelist',
                    ui: 'nav',
                    expanderOnly: false,
                    expanderFirst: false,
                    singleExpand: true,
                    bind: {
                        store: '{navRol}',
                        selection: '{selectMenu}'
                    }
                    , listeners: {
//                itemclick: function (treelist, ctx) {
//                    console.log("click");
//                },
                        selectionchange: 'treeNodeSelect'
                    }
                }],
            scrollable: 'y',
            flex: 3
        }, {
            title: 'Información',
            iconCls: 'x-fa fa-info-circle',
            scrollable: 'y',
            flex: 1,
            defaults: {
                xtype: 'combo',
                labelWidth: 55
            },
            items: [{
                    padding: '3px 0 0 0',
                    fieldLabel: 'Empresa',
                    displayField: 'descripcion',
                    valueField: 'idEmpresa',
                    bind: {
                        store: '{empresas}',
                        value: '{thisUsuario.idEmpresa}',
                        selection: '{selectEmpresa}'
                    },
                    readOnly: true,
                    forceSelection: true,
                    editable: false
                }, {
                    margin: '-6px 0 0 0',
                    fieldLabel: 'Sucursal',
                    displayField: 'descripcion',
                    valueField: 'idSucursal',
                    bind: {
                        store: '{sucursals}',
                        value: '{thisUsuario.idSucursal}',
                        selection: '{selectSucursal}'
                    },
                    forceSelection: true,
                    editable: false
                }]
        }]

});