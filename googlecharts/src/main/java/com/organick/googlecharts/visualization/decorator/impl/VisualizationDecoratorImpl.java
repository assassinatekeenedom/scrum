/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.impl;

/**
 *
 * @author nkeene
 */
public abstract class VisualizationDecoratorImpl extends DecoratorImpl {

    private final String type = "DIV";

    public String getDecoratorType() {
        return this.type;
    }
}
