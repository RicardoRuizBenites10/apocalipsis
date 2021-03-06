Ext.define('Ext.ux.TreePicker', {
    extend: 'Ext.form.field.Picker',
    alias: 'widget.treepicker',

    requires: [
        'Ext.tree.Panel'
    ],

    triggerCls: Ext.baseCSSPrefix + 'form-arrow-trigger',

    config: {
        /**
         * @cfg {Ext.data.TreeStore} store
         * A tree store that the tree picker will be bound to
         */
        store: null,

        /**
         * @cfg {String} qualifiedPath
         * A fully qualified path for the store, in case used from another application
         */
        qualifiedPath: "",

        /**
         * @cfg {String} displayField
         * The field inside the model that will be used as the node's text.
         * Defaults to the default value of {@link Ext.tree.Panel}'s `displayField` configuration.
         */
        displayField: null,
        valueField: null,

        /**
         * @cfg {Array} columns
         * An optional array of columns for multi-column trees
         */
        columns: null,

        /**
         * @cfg {Boolean} selectOnTab
         * Whether the Tab key should select the currently highlighted item. Defaults to `true`.
         */
        selectOnTab: true,

        /**
         * @cfg {Number} maxPickerHeight
         * The maximum height of the tree dropdown. Defaults to 300.
         */
        maxPickerHeight: 300,

        /**
         * @cfg {Number} minPickerHeight
         * The minimum height of the tree dropdown. Defaults to 100.
         */
        minPickerHeight: 100,

        /**
         *
         * @cfg {Boolean} leafOnly
         * Whether the "select" event should only be fired when for leaves
         */
        leafOnly: false
    },

    editable: false,

    initComponent: function () {
        var me = this;

        if (typeof me.store === "string") {
            var tempStore = Ext.StoreManager.lookup(me.qualifiedPath + me.store);
            if (tempStore === undefined) {
                me.store = Ext.StoreManager.lookup(me.store);
            } else {
                me.store = Ext.StoreManager.lookup(me.qualifiedPath + me.store);
            }
        }

        if (me.store === null || me.store === undefined) {
            me.store = Ext.create('Ext.data.TreeStore', {
                root: {
                    expanded: true,
                    children: []
                }
            });
        }

        if (me.store.getRootNode() === null || me.store.getRootNode() === undefined) {
            me.store.setRootNode(
                    {
                        expanded: true,
                        children: []
                    }
            );
        }

        me.callParent(arguments);

        //me.addEvents(
        //    /**
        //     * @event select
        //     * Fires when a tree node is selected
        //     * @param {Ext.ux.TreePicker} picker        This tree picker
        //     * @param {Ext.data.Model} record           The selected record
        //     */
        //    'select'
        //);

        me.mon(me.store, {
            scope: me,
            load: me.onLoad,
            update: me.onUpdate
        });
    },

    /**
     * Creates and returns the tree panel to be used as this field's picker.
     */
    createPicker: function () {
        var me = this,
                picker = new Ext.tree.Panel({
                    shrinkWrap: 2,
                    store: me.store,
                    floating: true,
                    displayField: me.displayField,
                    valueField: me.valueField,
                    columns: me.columns,
                    /*
                     resizable: true,
                     resizeHandles: 's e se',
                     autoScroll: true,
                     width: 300,
                     minWidth: me.bodyEl.getWidth(),
                     */

                    // minHeight: me.minPickerHeight,
                    // maxHeight: me.maxPickerHeight,
                    maxHeight: me.maxTreeHeight,
                    manageHeight: false,
                    rootVisible: me.rootVisible,
                    shadow: false,
                    listeners: {
                        scope: me,
                        itemclick: me.onItemClick
                    },
                    viewConfig: {
                        listeners: {
                            scope: me,
                            render: me.onViewRender
                        }
                    }
                }),
                view = picker.getView();

        view.on('render', me.setPickerViewStyles, me);

        if (Ext.isIE9 && Ext.isStrict) {
            // In IE9 strict mode, the tree view grows by the height of the horizontal scroll bar when the items are highlighted or unhighlighted.
            // Also when items are collapsed or expanded the height of the view is off. Forcing a repaint fixes the problem.
            view.on({
                scope: me,
                highlightitem: me.repaintPickerView,
                unhighlightitem: me.repaintPickerView,
                afteritemexpand: me.repaintPickerView,
                afteritemcollapse: me.repaintPickerView
            });
        }

        return picker;
    },

    /**
     * Aligns the picker to the input element
     */
    alignPicker: function () {
        var me = this,
                picker;

        if (me.isExpanded) {
            picker = me.getPicker();
            if (me.matchFieldWidth) {
                // Auto the height (it will be constrained by max height)
                picker.setWidth(me.bodyEl.getWidth());
            }
            if (picker.isFloating()) {
                me.doAlign();
            }
        }
    },

    /**
     * repaints the tree view
     */
    repaintPickerView: function () {
        var style = this.picker.getView().getEl().dom.style;
        // can't use Element.repaint because it contains a setTimeout, which results in a flicker effect
        style.display = style.display;
    },

    /**
     * Handles a click even on a tree node
     * @private
     * @param {Ext.tree.View} view
     * @param {Ext.data.Model} record
     * @param {HTMLElement} node
     * @param {Number} rowIndex
     * @param {Ext.EventObject} e
     */
    onItemClick: function (view, record, node, rowIndex, e) {
        this.selectItem(record);
    },

    /**
     * Handles a keypress event on the picker element
     * @private
     * @param {Ext.event.Event} e 
     * @param {HTMLElement} el 
     */
    onPickerKeyDown: function (treeView, record, item, index, e) {
        var key = e.getKey();

        if (key === e.ENTER || (key === e.TAB && this.selectOnTab)) {
            this.selectItem(record);
        }
    },

    /**
     * Changes the selection to a given record and closes the picker
     * @private
     * @param {Ext.data.Model} record
     */
    selectItem: function (record) {
        var me = this;

        if (me.leafOnly) {
            if (record.data['leaf']) {
                if (me.valueField === null) {
                    me.setValue(record.getId());
                } else {
                    me.setValue(record.get(me.valueField));
                }
                // me.picker.hide();
                me.collapse();
                me.inputEl.focus();
                me.fireEvent('select', me, record);
            }
        } else {
            if (me.valueField === null) {
                me.setValue(record.getId());
            } else {
                me.setValue(record.get(me.valueField));
            }
            // me.picker.hide();
            me.collapse();
            me.inputEl.focus();
            me.fireEvent('select', me, record);
        }
    },

    setPickerViewStyles: function (view) {
        view.getEl().setStyle({
            'min-height': this.minPickerHeight + 'px',
            'max-height': this.maxPickerHeight + 'px'
        });
    },

    /**
     * Runs when the picker is expanded.  Selects the appropriate tree node based on the value of the input element,
     * and focuses the picker so that keyboard navigation will work.
     * @private
     */
    onExpand: function () {
        var me = this,
                picker = me.picker,
                store = picker.store,
                value = me.value,
                node;

        if (value) {
            node = store.getNodeById(value);
        }

        if (!node) {
            node = store.getRootNode();
        }

        picker.selectPath(node.getPath());


        Ext.defer(function () {
            picker.getView().focus();
        }, 1);
    },

    /**
     * Sets the specified value into the field
     * @param {Mixed} value
     * @return {Ext.ux.TreePicker} this
     */
    setValue: function (value) {
        var me = this, record;

        me.value = value;
        if (me.store.loading) {
            // Called while the Store is loading. Ensure it is processed by the onLoad method.
            return me;
        }
        
        // try to find a record in the store that matches the value
        record = value ? me.store.getNodeById(value) : me.store.getRootNode();
        if (value === undefined) {
            record = me.store.getRootNode();
            me.value = record.getId();
        } else {
            record = me.store.getNodeById(value);
        }

        // set the raw value to the record's display field if a record was found
        me.setRawValue(record ? record.get(me.displayField) : '');

        return me;
    },

    getSubmitValue: function () {
        return this.value;
    },

    /**
     * Returns the current data value of the field (the idProperty of the record)
     * @return {Number}
     */
    getValue: function () {
        return this.value;
    },

    /**
     * Handles the store's load event.
     * @private
     */
    onLoad: function () {
        var value = this.value;
        console.log(value);
        if (value) {
            this.setValue(value);
        }
    },

    onUpdate: function (store, rec, type, modifiedFieldNames) {
        var display = this.displayField;

        if (type === 'edit' && modifiedFieldNames && Ext.Array.contains(modifiedFieldNames, display) && this.value === rec.getId()) {
            this.setRawValue(rec.get(display));
        }
    },

    onViewRender: function (view) {
        view.getEl().on('keypress', this.onPickerKeypress, this);
    },

    /**
     * Handles a keypress event on the picker element
     * @private
     * @param {Ext.EventObject} e
     * @param {HTMLElement} el
     */
    onPickerKeypress: function (e, el) {
        var key = e.getKey();

        if (key === e.ENTER || (key === e.TAB && this.selectOnTab)) {
            this.selectItem(this.picker.getSelectionModel().getSelection()[0]);
        }
    }

});