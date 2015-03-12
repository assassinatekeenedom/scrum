package com.keene.mepbm.natural.science.physics;

import com.keene.mepbm.natural.science.observation.Name;

/**
 *
 * An Example.
 *
 */
public class Neutron extends Particle<Neutron>{

    public Neutron(String name, String context) {
        super(Particle.Meta.NEUTRON.getName()+Name.Meta.DELIMITER.getName()+name, context);
    }

    public Neutron(String context) {
        super(Particle.Meta.NEUTRON.getName(), context);
    }

}
