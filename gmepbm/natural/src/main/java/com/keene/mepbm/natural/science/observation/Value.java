package com.keene.mepbm.natural.science.observation;
/**
 *
 * The second requirement for any observation are the values (one at a time) of an observable named entity.
 *
 * A name is a basic requirement for any observable entity.
 *
 */
public interface Value<V> extends Name{

    public V getValue();

    public void setValue(V value);

}
