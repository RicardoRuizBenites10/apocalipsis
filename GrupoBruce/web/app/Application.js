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
        // TODO: add global / shared stores here
    ],

    launch: function () {
        var loggedIn;
        loggedIn = localStorage.getItem("sesionUsuario");
        console.dir("Application: " + loggedIn);
        if (loggedIn || loggedIn === null) {
            console.dir("Application opcion app-main. ");
            Ext.create({
                xtype: 'app-main'
            });
        } else {
            console.dir("Application opcion login. ");
            Ext.create({
                xtype: 'login'
            });
        }

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
