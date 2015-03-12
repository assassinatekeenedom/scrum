package com.keene.mepbm.natural.science.physics;

import com.keene.mepbm.natural.science.observation.Perception;
import java.util.HashMap;

/**
 * 
 * "It is your mind that creates this world"
 *                          - the Buddah
 *
 * The Reality<P> underlies the Creator context; every Creator is tied to a Reality.
 *
 * Any time two Realities exchange Particles, they keep their original identity along with their new one.
 *
 * Realities can build on one another, but it is up to the End User/Developer to decipher the Pattern!
 *
 * You can always request all of the particles created within a particular reality, because of this (context building) Reality<P>.
 *
 * And so, it is important that the reality built can be accessed through requests built around the context.
 *
 */
public class Simulation<P extends Particle> extends HashMap<String, P> implements Perception<P> {

    private final Particle<P> reality;

    protected Simulation(final String context) {
        this.reality = new Particle(Particle.Meta.SIMULATION.getName(), context);
    }

    @Override
    public String getName() {
        return this.reality.getName();
    }

    @Override
    public P getNamedModel(String name) {
        return this.get(name);
    }

    @Override
    public void addNamedModel(String name, P particle) {
        this.put(name, particle);
    }

    @Override
    public String getCurrentContextName() {
        return this.reality.getCurrentContextName();
    }

    @Override
    public String getParentContextName() {
        return this.reality.getParentContextName();
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tPerception: ");
        toString.append("\n\t\tReality: ");
        toString.append(this.getName());
        toString.append("\n\t\tParent Reality: ");
        toString.append(this.getParentContextName());
        toString.append("\n\t\tCurrent Reality: ");
        toString.append(this.getCurrentContextName());
        toString.append("\n\t\tCurrently Reality Size: ");
        toString.append(this.size());
//        toString.append("\n\t\tCurrently in Reality {");
//        for (String key : this.keySet()) {
//            toString.append("\n\t\t\t");
//            toString.append(key);
//            toString.append(this.get(key));
//        }
//        toString.append("\n\t\t }");
        return toString.toString();
    }
}
