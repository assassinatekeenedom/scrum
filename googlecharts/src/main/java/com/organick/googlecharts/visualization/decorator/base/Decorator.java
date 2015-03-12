/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.visualization.decorator.base;

import java.util.Map;

/**
 *
 * @author nkeene
 */
public interface Decorator {

    public Map<String, String> getDecoratorMap();
    public String getDecoratorString();
    public void setDecoratorString(String decorators);
    public void buildDecoratorString();
    public String getDecoratorType();
    public <T extends Decorator>T getDefaultDecorator();

}
