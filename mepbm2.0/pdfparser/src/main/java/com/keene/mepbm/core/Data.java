package com.keene.mepbm.core;

public abstract class Data<P extends Persistence> {

    public Data() {
    }

    public abstract P getPersistence();
    public abstract void setPersistence(P persistence);
}
