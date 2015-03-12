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
public class TreemapDecorator extends VisualizationDecoratorImpl {

    public static final String SHOW_SCALE = "showScale";

    public Map<String, String> getDecoratorMap() {
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(SHOW_SCALE, this.getShowScaleDecorator());
        return configurations;
    }
    private boolean showScale;

    public boolean isShowScale() {
        return showScale;
    }

    public void setShowScale(boolean showScale) {
        this.showScale = showScale;
    }

    public TreemapDecorator() {
    }

    private String getShowScaleDecorator() {
        return "" + showScale;
    }
    
    public <T extends Decorator>T getDefaultDecorator() {
        this.setShowScale(true);
        return (T)this;
    }
}
