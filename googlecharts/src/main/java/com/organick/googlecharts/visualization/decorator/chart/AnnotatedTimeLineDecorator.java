package com.organick.googlecharts.visualization.decorator.chart;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.impl.VisualizationDecoratorImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nkeene
 */
public class AnnotatedTimeLineDecorator extends VisualizationDecoratorImpl {

    public static final String DISPLAY_ANNOTATIONS = "displayAnnotations";

    public Map<String, String> getDecoratorMap() {
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(DISPLAY_ANNOTATIONS, this.getDisplayAnnotationsDecorator());
        return configurations;
    }

    private boolean displayAnnotations;

    public AnnotatedTimeLineDecorator() {
    }

    public void setDisplayAnnotations(boolean displayAnnotations) {
        this.displayAnnotations = displayAnnotations;
    }

    public String getDisplayAnnotationsDecorator() {
        return ""+displayAnnotations;
    }

    public <T extends Decorator>T getDefaultDecorator() {
        this.setDisplayAnnotations(true);
        return (T)this;
    }
}
