package com.keene.mepbm.natural.science.observation;

import java.util.HashMap;

/**
 *
 * The NamedModel is the basis for building multi-dimentional relationships between a model and its related values.
 *
 */
public class NamedModel<V> extends HashMap<String, NamedValue<V>> implements Name, Context {

    protected NamedModel(final String name, final String context) {
        this.put(Name.Meta.NAME.getName(), new NamedValue(Name.Meta.NAME.getName(), name));
        this.put(Name.Meta.PARENT_CONTEXT.getName(), new NamedValue(Name.Meta.NAME.getName(), context));
        this.put(Name.Meta.CURRENT_CONTEXT.getName(), new NamedValue(Name.Meta.NAME.getName(),context+Name.Meta.DELIMITER.getName()+ name));
    }

    @Override
    public String getName() {
        return (String)((NamedValue) this.get(Name.Meta.NAME.getName())).getValue();
    }

    @Override
    public String getCurrentContextName() {
        return (String)((NamedValue) this.get(Name.Meta.CURRENT_CONTEXT.getName())).getValue();
    }

    @Override
    public String getParentContextName() {
        return (String)((NamedValue) this.get(Name.Meta.PARENT_CONTEXT.getName())).getValue();
    }

    @Override
    public String toString() {
        return Name.Meta.NAME.getName()+"="+this.getName()+", "+Name.Meta.PARENT_CONTEXT.getName()+"="+this.getParentContextName()+", "+Name.Meta.CURRENT_CONTEXT.getName()+"="+this.getCurrentContextName();
    }
}