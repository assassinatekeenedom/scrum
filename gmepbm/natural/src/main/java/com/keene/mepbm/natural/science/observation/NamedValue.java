package com.keene.mepbm.natural.science.observation;

/**
 *
 * The NamedValue is a particular Value<V> with a Name association and creates the first building block for the named-value design.
 *
 */
public class NamedValue<V extends Object> implements Value<V>,Name {

    private final String name;
    private V value;

    NamedValue(final String name, final V value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName() + " { " + "name=" + name + ", value=" + value + " }";
    }

}
