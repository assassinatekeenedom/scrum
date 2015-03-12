/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.chart.impl;

import com.organick.googlecharts.chart.VennDiagram;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.VennDiagramDecorator;
import com.organick.googlecharts.visualization.impl.VisualizationImpl;

/**
 *
 * @author nkeene
 */
public class VennDiagramImpl extends VisualizationImpl implements VennDiagram {

    private VennDiagramDecorator vennDiagramDecorator;

    public VennDiagramImpl() {
        this.vennDiagramDecorator = new VennDiagramDecorator();
    }

    public boolean addFirstElement(String name, long data, String color) {
        this.vennDiagramDecorator.addSphereName(name);
        this.vennDiagramDecorator.addSphereData(data);
        this.vennDiagramDecorator.addSphereColor(color);
        return true;
    }

    public Decorator getDecorations() {
       return this.vennDiagramDecorator;
    }

    public void setDecorations(Decorator decorator) {        
        this.vennDiagramDecorator = (VennDiagramDecorator)decorator;
    }

    public boolean addSecondElement(String name, long data, String color) {
        this.vennDiagramDecorator.addSphereName(name);        
        this.vennDiagramDecorator.addSphereData(data);
        this.vennDiagramDecorator.addSphereColor(color);
        return true;
    }

    public boolean addThirdElement(String name, long data, String color) {
        this.vennDiagramDecorator.addSphereName(name);
        this.vennDiagramDecorator.addSphereData(data);
        this.vennDiagramDecorator.addSphereColor(color);
        return true;
    }

    public boolean addFirstInterceptSecond(long data) {        
        this.vennDiagramDecorator.addSphereData(data);
        return true;
    }

    public boolean addFirstInterceptThird(long data) {
        this.vennDiagramDecorator.addSphereData(data);
        return true;
    }

    public boolean addSecondInterceptThird(long data) {
        this.vennDiagramDecorator.addSphereData(data);
        return true;
    }

    public boolean addCommonIntercept(long data) {
        this.vennDiagramDecorator.addSphereData(data);
        return true;
    }
}
