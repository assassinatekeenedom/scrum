package com.keene.mepbm.natural.science.physics;

import com.keene.mepbm.natural.science.observation.Name;
import com.keene.mepbm.natural.science.observation.NamedModel;

/**
 *
 * A Creator is responsible for creating Particles and adding them to a particular Reality.
 *
 * A Particle is a logical observable model that is treated as a single abstracted unit.
 *
 * A Particle can contain any type of data, including other Particles.
 *
 * Every Particle should also be considered a "Named Model" with a list of other "Named Models" and "Named Values" associated with it.
 *
 * All Particles Look The Same, Until You Look Inside! A Law of Nature, and the Nature of the Composite Pattern.
 *
 */
public class Particle<P extends NamedModel> extends NamedModel<P> {

    protected Particle(String name, String context) {
        super(Particle.Meta.PARTICLE.getName() + Name.Meta.DELIMITER.getName() + name, context);
    }

    protected Particle(String context) {
        super(Particle.Meta.PARTICLE.getName(), context);
    }

    public enum Meta {

        PARTICLE("PARTICLE"),
        PHYSICIST("PHYSICIST"),
        SIMULATION("SIMULATION"),
        ELECTRON("ELECTRON"),
        NEUTRON("NEUTRON"),
        PROTON("PROTON");
        private final String name;

        private Meta(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tName: ");
        toString.append(this.getName());
        toString.append("\n\tType: ");
        toString.append(Particle.Meta.PARTICLE.getName());
        toString.append("\n\t\tReality Name: ");
        toString.append(this.getParentContextName());
        toString.append("\n\t\tParent Reality (root if same as previous): ");
        toString.append(this.getParentContextName());
        toString.append("\n\t\tDetails - ");
        toString.append(this.getCurrentContextName());
        toString.append("\n");
        return toString.toString();
    }
}
