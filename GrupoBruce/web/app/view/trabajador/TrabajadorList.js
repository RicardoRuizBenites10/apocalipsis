Ext.define('GrupoBruce.view.trabajador.TrabajadorList',{
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',
    
    requires: [
        'GrupoBruce.store.Trabajador'
    ],
    
    store: {
        xtype: 'Strabajador'
    },
    
    columns:[{
            text: 'DNI', 
            dataIndex: 'persona.dni'
        },{
            text: 'Apellidos', 
            dataIndex:'persona.apPaterno',
            flex: 1
        },{
            text: 'Nombres', 
            dataIndex:'persona.nombres',
            flex: 1
        }
    ]
    
});


