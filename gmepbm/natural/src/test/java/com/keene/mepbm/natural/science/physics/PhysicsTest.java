package com.keene.mepbm.natural.science.physics;

import com.keene.mepbm.natural.science.observation.Gatekeeper;
import com.keene.mepbm.natural.science.observation.Name;
import com.keene.mepbm.natural.science.observation.Perception;
import org.junit.Test;

public class PhysicsTest {

    private static final String tester = "nathan";
    private static final String context = "testing";
    private static final String custom = "custom";
    private static final Gatekeeper gatekeeper = new Physicist(tester, context);
    private static final Perception perception = gatekeeper.getReality();
    private static final Electron electron = ((Physicist) gatekeeper).createElectron();
    private static final Proton proton = ((Physicist) gatekeeper).createProton();
    private static final Neutron neutron = ((Physicist) gatekeeper).createNeutron();
    private static final Electron customElectron = ((Physicist) gatekeeper).createCustomElectron(custom);
    private static final Proton customProton = ((Physicist) gatekeeper).createCustomProton(custom);
    private static final Neutron customNeutron = ((Physicist) gatekeeper).createCustomNeutron(custom);
    private static final String particleComma = Particle.Meta.PARTICLE.getName() + Name.Meta.DELIMITER.getName();
    private static final String particleSimulation = particleComma + Particle.Meta.SIMULATION.getName();
    private static final String simulation = context + Name.Meta.DELIMITER.getName() + particleSimulation;
    private static final String simulationTester = context + Name.Meta.DELIMITER.getName() + particleComma + Particle.Meta.SIMULATION.getName() + Name.Meta.DELIMITER.getName() + tester;
    private static final String simulationTesterComma = simulationTester + Name.Meta.DELIMITER.getName();
    private static final String electronComma = particleComma + Particle.Meta.ELECTRON.getName() + Name.Meta.DELIMITER.getName();
    private static final String protonComma = particleComma + Particle.Meta.PROTON.getName() + Name.Meta.DELIMITER.getName();
    private static final String neutronComma = particleComma + Particle.Meta.NEUTRON.getName() + Name.Meta.DELIMITER.getName();
    private static final String electronDefault = electronComma + Particle.Meta.ELECTRON.getName();
    private static final String protonDefault = protonComma + Particle.Meta.PROTON.getName();
    private static final String neutronDefault = neutronComma + Particle.Meta.NEUTRON.getName();
    private static final String simulationTesterElectron = simulationTesterComma + electronDefault;
    private static final String simulationTesterProton = simulationTesterComma + protonDefault;
    private static final String simulationTesterNeutron = simulationTesterComma + neutronDefault;
    private static final String electronCustom = particleComma + Particle.Meta.ELECTRON.getName() + Name.Meta.DELIMITER.getName() + custom;
    private static final String protonCustom = particleComma + Particle.Meta.PROTON.getName() + Name.Meta.DELIMITER.getName() + custom;
    private static final String neutronCustom = particleComma + Particle.Meta.NEUTRON.getName() + Name.Meta.DELIMITER.getName() + custom;
    private static final String simulationTesterElectronCustom = simulationTesterComma + electronCustom;
    private static final String simulationTesterProtonCustom = simulationTesterComma + protonCustom;
    private static final String simulationTesterNeutronCustom = simulationTesterComma + neutronCustom;

    public PhysicsTest() {
    }

    @Test
    public void testPerceptionDefault() {
        assert particleSimulation.equals(perception.getName());
        assert context.equals(perception.getParentContextName());
        assert simulation.equals(perception.getCurrentContextName());
    }

    @Test
    public void testGatekeeperDefault() {
        printDetails();
        assert tester.equals(gatekeeper.getName());
    }

    @Test
    public void testElectronDefault() {
        assert electronDefault.equals(electron.getName());
        assert simulationTester.equals(electron.getParentContextName());
        assert simulationTesterElectron.equals(electron.getCurrentContextName());
    }

    @Test
    public void testProtonDefault() {
        assert protonDefault.equals(proton.getName());
        assert simulationTester.equals(electron.getParentContextName());
        assert simulationTesterProton.equals(proton.getCurrentContextName());
    }

    @Test
    public void testNeutronDefault() {
        assert neutronDefault.equals(neutron.getName());
        assert simulationTester.equals(electron.getParentContextName());
        assert simulationTesterNeutron.equals(neutron.getCurrentContextName());
    }

    @Test
    public void testCustomElectronDefault() {
        assert electronCustom.equals(customElectron.getName());
        assert simulationTester.equals(electron.getParentContextName());
        assert simulationTesterElectronCustom.equals(customElectron.getCurrentContextName());
    }

    @Test
    public void testCustomProtonDefault() {
        assert protonCustom.equals(customProton.getName());
        assert simulationTester.equals(electron.getParentContextName());
        assert simulationTesterProtonCustom.equals(customProton.getCurrentContextName());
    }

    @Test
    public void testCustomNeutronDefault() {
        assert neutronCustom.equals(customNeutron.getName());
        assert simulationTester.equals(electron.getParentContextName());
        assert simulationTesterNeutronCustom.equals(customNeutron.getCurrentContextName());
    }

    private void printDetails() {
        System.out.println("gatekeeper: \n" + gatekeeper);
        System.out.println("electron: \n" + electron);
        System.out.println("proton: \n" + proton);
        System.out.println("neutron: \n" + neutron);
        System.out.println("customElectron: \n" + customElectron);
        System.out.println("customProton: \n" + customProton);
        System.out.println("customNeutron: \n" + customNeutron);
//        System.out.println("particleComma: " + particleComma);
//        System.out.println("particleSimulation: " + particleSimulation);
//        System.out.println("simulation: " + simulation);
//        System.out.println("simulationTester: " + simulationTester);
//        System.out.println("simulationTesterComma: " + simulationTesterComma);
//        System.out.println("simulationTesterElectron: " + simulationTesterElectron);
//        System.out.println("simulationTesterProton: " + simulationTesterProton);
//        System.out.println("simulationTesterNeutron: " + simulationTesterNeutron);
//        System.out.println("electronDefault: " + electronDefault);
//        System.out.println("protonDefault: " + protonDefault);
//        System.out.println("neutronDefault: " + neutronDefault);
//        System.out.println("electronCustom: " + electronCustom);
//        System.out.println("protonCustom: " + protonCustom);
//        System.out.println("neutronCustom: " + neutronCustom);
    }
}
