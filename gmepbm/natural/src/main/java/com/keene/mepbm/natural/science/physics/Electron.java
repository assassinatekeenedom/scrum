package com.keene.mepbm.natural.science.physics;

import com.keene.mepbm.natural.science.observation.Name;

/**
 *
 * An Example.
 * 
 */
public class Electron extends Particle<Electron> {

    public Electron(String name, String context) {
        super(Particle.Meta.ELECTRON.getName() + Name.Meta.DELIMITER.getName() + name, context);
    }

    public Electron(String context) {
        super(Particle.Meta.ELECTRON.getName(), context);
    }
}
