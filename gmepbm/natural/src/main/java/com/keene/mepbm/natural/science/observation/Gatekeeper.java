package com.keene.mepbm.natural.science.observation;
/**
 * 
 * Controls what's allowed within a reality.
 *
 * Only a Gatekeeper can 'create' new NamedModels.
 *
 */
public abstract class Gatekeeper<M extends NamedModel, P extends Perception<M>> extends NamedModel<M> {

    private final P reality;

    protected Gatekeeper(String name, P reality) {
        super(name, reality.getCurrentContextName());
        this.reality = reality;
    }

    public abstract M create(String name);

    public void addToReality(String name, M model){
        this.reality.put(name, model);
    }

    public P getReality() {
        return this.reality;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tGatekeeper: ");
        toString.append(this.getName());
        toString.append("\n");
        toString.append(this.reality);
        return toString.toString();
    }

}
