package com.keene.mepbm.core;

public abstract class Section<D extends Data> extends Processor<D>{

    public Section() {
    }

    @Override
    public abstract void process();

}
