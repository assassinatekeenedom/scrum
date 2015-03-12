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
public class RotatingCloudDecorator extends VisualizationDecoratorImpl {

    public static final String TEXT_COLOR = "text_color";
    public static final String HOVER_TEXT_COLOR = "hover_text_color";
    public static final String HEIGHT = "height";
    public static final String WIDTH = "width";
    public static final String SPEED = "speed";

    public Map<String, String> getDecoratorMap() {
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(TEXT_COLOR, this.getTextColorDecorator());
        configurations.put(HOVER_TEXT_COLOR, this.getHoverTextColorDecorator());
        configurations.put(HEIGHT, this.getHeightDecorator());
        configurations.put(WIDTH, this.getWidthDecorator());
        configurations.put(SPEED, this.getSpeedDecorator());        
        return configurations;
    }
    private String textColor;
    private String hoverTextColor;
    private long height;
    private long width;
    private long speed;

    public RotatingCloudDecorator() {
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setHoverTextColor(String hoverTextColor) {
        this.hoverTextColor = hoverTextColor;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public String getHeightDecorator() {
        return "" + this.height;
    }

    public String getWidthDecorator() {
        return "" + this.width;
    }

    public String getTextColorDecorator() {
        return "'" + this.textColor+"'";
    }

    public String getHoverTextColorDecorator() {
        return "'" + this.hoverTextColor+"'";
    }

    public String getSpeedDecorator() {
        return "" + this.speed;
    }

    public <T extends Decorator> T getDefaultDecorator() {
        this.setHeight(200);
        this.setWidth(200);
        this.setSpeed(100);
        this.setTextColor("#00ff00");
        this.setHoverTextColor("#00ffff");
        return (T)this;
    }
}
