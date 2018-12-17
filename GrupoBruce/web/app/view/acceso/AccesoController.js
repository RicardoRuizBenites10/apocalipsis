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

    onTransform: function (extendModel) {
        var model = new GrupoBruce.model.Acceso();
        model.set('idMenu', extendModel.get('idMenu'));
        model.set('idSupmenu', extendModel.get('idSupmenu'));
        model.set('text', extendModel.get('text'));
        model.set('leaf', extendModel.get('leaf'));
        model.set('checked', extendModel.get('checked'));
        model.set('fechaUpdate', Ext.Date.format(new Date(), 'c'));
        model.set('idRol', extendModel.get('idRol'));
        return model.data;
    },

    saveAcceso: function (btn) {
        var grid = btn.up('WlistAcceso');
        var store = grid.getStore();
        var jsonData = [];
        var scope = this;
        
        store.each(function (model) {
            jsonData.push(scope.onTransform(model));
            if (!model.get('leaf')) {
                model.parentNode.eachChild(function (child) {
                    jsonData.push(scope.onTransform(child));
                });
            }
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
