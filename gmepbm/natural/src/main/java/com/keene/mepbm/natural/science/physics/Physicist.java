package com.keene.mepbm.natural.science.physics;

import com.keene.mepbm.natural.science.observation.Gatekeeper;

/**
 *
 * A Creator is responsible for new Particles and their NamedModel.
 *
 * Each Creator will declare the Particles it is capable of creating, and be responsible for how they are created and accessed.
 *
 */
public class Physicist<P extends Particle> extends Gatekeeper<P, Simulation<P>> {

    public Physicist(String name, String context) {
        super(name, new Simulation(context));
    }

    public Electron createElectron() {
        Electron electron = new Electron(Particle.Meta.ELECTRON.getName(), this.getCurrentContextName());
        this.addToReality(Particle.Meta.ELECTRON.getName(), (P) electron);
        return electron;
    }

    public Proton createProton() {
        Proton proton = new Proton(Particle.Meta.PROTON.getName(), this.getCurrentContextName());
        this.addToReality(Particle.Meta.PROTON.getName(), (P) proton);
        return proton;
    }

    public Neutron createNeutron() {
        Neutron neutron = new Neutron(Particle.Meta.NEUTRON.getName(), this.getCurrentContextName());
        this.addToReality(Particle.Meta.NEUTRON.getName(), (P) neutron);
        return neutron;
    }

    public Electron createCustomElectron(String name) {
        Electron electron = new Electron(name, this.getCurrentContextName());
        this.addToReality(name + Particle.Meta.ELECTRON.getName(), (P) electron);
        return electron;
    }

    public Proton createCustomProton(String name) {
        Proton proton = new Proton(name, this.getCurrentContextName());
        this.addToReality(name + Particle.Meta.PROTON.getName(), (P) proton);
        return proton;
    }

    public Neutron createCustomNeutron(String name) {
        Neutron neutron = new Neutron(name, this.getCurrentContextName());
        this.addToReality(name + Particle.Meta.NEUTRON.getName(), (P) neutron);
        return neutron;
    }

    @Override
    public P create(String name) {
        P particle = (P) new Particle(name, this.getCurrentContextName());
        this.addToReality(name, particle);
        return particle;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append(Particle.Meta.PHYSICIST.getName());
        toString.append(":\n");
        toString.append(super.toString());
        return toString.toString();
    }
}
