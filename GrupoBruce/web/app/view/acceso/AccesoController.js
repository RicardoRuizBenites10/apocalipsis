Ext.define('GrupoBruce.view.acceso.AccesoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cacceso',
    
    onChangeSelect: function (node, checked, opts) {
        if (checked) {
            node.parentNode.set('checked', checked);
        } else {
//            node.parentNode.eachChild(function (child) {
//                console.log(child.get('text'));
//            });
        }
    },
    
    saveAcceso: function(btn){
        var grid = btn.up('grid');
        var store = grid.getStore();
        var jsonData = [];
        store.each(function (model) {
            model.data.fecha = Ext.Date.format(model.get('fechaTemp'), 'c');
            model.data.hmarca = Ext.Date.format(model.get('hmarca'), 'h:i A');
            jsonData.push(model.data);
        });

        Ext.Ajax.request({
            url: 'iiAsistenciaList',
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
