Ext.define('GrupoBruce.view.main.MainMenu', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.WmainMenu',
    reference: 'main_menu',
    id: 'id_mainMenu',

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
            xtype: 'treelist',
            reference: 'treelist',
            ui: 'nav',
            expanderOnly: false,
            expanderFirst: false,
            singleExpand: true,
            bind: {
                store: '{navRol}'
            }
            , listeners: {
//                itemclick: function (treelist, ctx) {
//                    console.log("click");
//                },
                selectionchange: 'treeNodeSelect'

            }
        }]

});