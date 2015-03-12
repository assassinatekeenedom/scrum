package com.keene.mepbm.natural.science.physics;

import com.keene.mepbm.natural.science.observation.Name;

/**
 *
 * An Example.
 *
 */
public class Proton extends Particle<Proton> {

    public Proton(String name, String context) {
        super(Particle.Meta.PROTON.getName()+Name.Meta.DELIMITER.getName()+name, context);
    }

    public Proton(String context) {
        super(Particle.Meta.PROTON.getName(), context);
    }

}
