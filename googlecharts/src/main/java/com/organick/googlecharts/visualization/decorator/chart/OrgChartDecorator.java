/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.chart;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.impl.VisualizationDecoratorImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nkeene
 */
public class OrgChartDecorator extends VisualizationDecoratorImpl {

    public static final String ALLOW_COLLAPSE = "allowCollapse";

    public Map<String, String> getDecoratorMap() {
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(ALLOW_COLLAPSE, this.getAllowCollapseDecorator());
        return configurations;
    }
    private boolean allowCollapse;

    public OrgChartDecorator() {
    }

    private String getAllowCollapseDecorator() {
        return "" + allowCollapse;
    }

    public void setAllowCollapse(boolean allowCollapse) {
        this.allowCollapse = allowCollapse;
    }
    public <T extends Decorator>T getDefaultDecorator() {
        this.setAllowCollapse(true);
        return (T)this;
    }
}
