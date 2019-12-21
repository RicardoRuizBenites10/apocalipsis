Ext.define('GrupoBruce.view.colordiseno.ColorDiseno', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.colordiseno.ColorDisenoController',
        'GrupoBruce.view.colordiseno.ColorDisenoModel',

        'GrupoBruce.view.colordiseno.FormColorDiseno',
        'GrupoBruce.view.colordiseno.ListColorDiseno'
    ],

    controller: 'Ccolordiseno',
    viewModel: {
        type: 'VMcolordiseno'
    },

    items: [{
            xtype: 'Wlistcolordiseno',
            plugins: 'responsive',
            responsiveConfig: {
                small: {
                    height: 300
                },
                medium: {
                    height: 540
                },
                large: {
                    height: 830
                }
            }
        }]
});
