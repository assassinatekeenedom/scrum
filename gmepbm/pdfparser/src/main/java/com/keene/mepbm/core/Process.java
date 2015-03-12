package com.keene.mepbm.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Process<D extends Data, P extends Processor, S extends Section> extends Processor<D>{

    private List<S> sections;

    public Process() {
    }

    public List<S> getSections() {
        if(this.sections==null){
            this.sections = new ArrayList<S>();
        }
        return this.sections;
    }

    public void setSections(List<S> sections) {
        this.sections = sections;
    }

    public void addSection(S section){
        this.getSections().add(section);
    }

    @Override
    public void process() {
        for(S section : this.getSections()){
            section.setData(this.getData());
            section.process();
        }
    }

}
