package com.keene.mepbm.natural.science.observation;

import java.util.Map;

public interface Perception<M extends NamedModel> extends Map<String, M>, Name, Context {

    public M getNamedModel(String name);

    public void addNamedModel(String name, M particle);
}