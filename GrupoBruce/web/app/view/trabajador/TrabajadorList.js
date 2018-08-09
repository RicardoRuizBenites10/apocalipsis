Ext.define('GrupoBruce.view.trabajador.TrabajadorList',{
    extend: 'Ext.grid.Panel',
    xtype: 'trabajadorList',
   
    title: 'Lista de trabajadores',
    
    store: {
        xtype: 'Strabajador'
    },
    columns:[{
            text: 'DNI', 
            dataIndex: 'idTrabajador'
        }
    ]
    
});


