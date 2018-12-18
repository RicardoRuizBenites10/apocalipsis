Ext.define('GrupoBruce.view.acceso.AccesoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cacceso',

    onChangeSelect: function (node, checked, opts) {
//        if (checked) {
//            node.parentNode.set('checked', checked);
//        } else {
//            node.parentNode.eachChild(function (child) {
//                console.log(child.get('text'));
//            });
//        }
    },

    goToNodes: function (jsonData, node) {
        var scope = this;
        node.data.fechaUpdate = Ext.Date.format(new Date(), 'c');
        node.set('fechaUpdate',new Date());
        jsonData.push(node.data);
        if (!node.get('leaf')) {
            node.eachChild(function (childNode) { //childNode.parentNode
               jsonData = scope.goToNodes(jsonData, childNode);
            });
        }
        return jsonData;
    },

    saveAcceso: function (btn) {
        var grid = btn.up('WlistAcceso');
        var store = grid.getStore();
        var jsonData = [];
        var scope = this;

        store.each(function (model) {
            jsonData = scope.goToNodes(jsonData, model);
        });

        Ext.Ajax.request({
            url: 'iiLAcceso',
            jsonData: jsonData,
            method: 'POST',
            scope: this,
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                store.removeAll();
                Ext.Msg.alert('Status', responseText.message);
                store.setData(responseText.data);
            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status', response.status);
            }
        });
    }

});
