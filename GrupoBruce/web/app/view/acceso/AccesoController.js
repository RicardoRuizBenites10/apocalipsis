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
//        node.data.fechaUpdate = Ext.Date.format(new Date(), 'c');
        node.set('fechaUpdate', new Date());
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

        store.sync({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Operación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
            }
        });
    }

});
