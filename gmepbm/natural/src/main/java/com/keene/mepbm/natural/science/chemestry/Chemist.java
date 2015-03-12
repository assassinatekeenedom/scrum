package com.keene.mepbm.natural.science.chemestry;

import com.keene.mepbm.natural.science.observation.Gatekeeper;

/**
 *
 * A Creator is responsible for new Particles and their NamedModel.
 *
 * Each Creator will declare the Particles it is capable of creating, and be responsible for how they are created and accessed.
 *
 */
public class Chemist<M extends Molecule> extends Gatekeeper<M, Labratory<M>> {

    public Chemist(String name, String context) {
        super(name, new Labratory(name));
    }

    @Override
    public M create(String name) {
        final String relativeName = this.getCurrentContextName() + name;
        M particle = (M) new Molecule(relativeName, this.getCurrentContextName());
        this.addToReality(relativeName, particle);
        return particle;
    }
}
