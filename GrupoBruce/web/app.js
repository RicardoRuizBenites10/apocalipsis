Ext.Loader.setPath('Ext.ux', 'overrides/ux');
Ext.application({
    name: 'GrupoBruce',

    extend: 'GrupoBruce.Application',

    requires: [
        'GrupoBruce.view.main.Main',
        'Ext.ux.ActivityMonitor'
    ]
});
