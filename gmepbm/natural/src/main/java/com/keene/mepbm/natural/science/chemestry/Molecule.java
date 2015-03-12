package com.keene.mepbm.natural.science.chemestry;

import com.keene.mepbm.natural.science.physics.*;
import com.keene.mepbm.natural.science.observation.NamedModel;

/**
 *
 * A Creator is responsible for creating Particles and adding them to a particular Reality.
 *
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
public class Molecule<P extends NamedModel> extends Particle<P> {

    protected Molecule(String name, String context) {
        super(name, context);
    }
}
