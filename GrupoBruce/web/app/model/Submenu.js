Ext.define('GrupoBruce.model.Submenu', {
    extend: 'Ext.data.Model',
    idProperty: 'idSubmenu',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idSubmenu', type: 'int' },
        { name: 'link', type: 'string' },
        { name: 'situacion', type: 'boolean' },
        { name: 'menuId', reference: 'Menu' }
    ]
});
