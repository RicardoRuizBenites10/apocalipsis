Ext.define('GrupoBruce.view.area.ListArea', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.WlistArea',
    reference: 'list_area',
    
    bind:{
        store: '{areas}'
    },
    rootVisible: false,
    animate: false,
    frame: true,
    reserveScrollbar: true,
    columns: [{
            xtype: 'treecolumn',
            text: 'Nombre',
            dataIndex: 'nombre',
            sortable: true
        }, {
            text: 'Type',
            renderer: function (v, cellValues, record) {
                return record.entityName;
            }
        }, {
            xtype: 'actioncolumn',
            iconCls: 'x-fa fa-info',
            width: 25,
            getTip: function (value, meta, rec, rowIdx, colIdx, store, view) {
                // Go up from the view to the owning TreePanel
                var panel = view.up('');
                return panel.getActionTip.apply(panel, arguments);
            },
            handler: function (view) {
                // Go up from the view to the owning TreePanel
                var panel = view.up('');
                panel.onDrillAction.apply(panel, arguments);
            }
        }]

});