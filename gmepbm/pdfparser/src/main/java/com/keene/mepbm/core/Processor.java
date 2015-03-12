package com.keene.mepbm.core;

import java.util.ArrayList;

public abstract class Processor<D extends Data> extends ArrayList<Processor>{

    private D data;

    public Processor() {
    }

    public void process(){
        for(Processor process : this){
            process.process();
        }
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

}
