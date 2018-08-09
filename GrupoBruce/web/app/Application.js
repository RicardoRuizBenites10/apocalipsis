Ext.define('GrupoBruce.Application', {
    extend: 'Ext.app.Application',

    name: 'GrupoBruce',

    quickTips: false,
    platformConfig: {
        desktop: {
            quickTips: true
        }
    },

    stores: [
        'GrupoBruce.store.Trabajador'
    ],

    launch: function () {
        var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
        console.dir("controller application: " + loggedIn);
        Ext.create({
                xtype: loggedIn ? 'app-main' : 'login'
            });

    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
                function (choice) {
                    if (choice === 'yes') {
                        window.location.reload();
                    }
                }
        );
    }
});
