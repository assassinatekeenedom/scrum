/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.impl;

/**
 *
 * @author nkeene
 */
public abstract class BasicDecoratorImpl extends DecoratorImpl {

    private final String type = "URL";

    public String getDecoratorType() {
        return this.type;
    }
}
