/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.chart;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.impl.VisualizationDecoratorImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nkeene
 */
public class GagueDecorator extends VisualizationDecoratorImpl {

    public static final String GREEN_FROM = "greenFrom";
    public static final String GREEN_TO = "greenTo";
    public static final String RED_FROM = "redFrom";
    public static final String RED_TO = "redTo";
    public static final String YELLOW_FROM = "yellowFrom";
    public static final String YELLOW_TO = "yellowTo";
    public static final String HEIGHT = "height";
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String WIDTH = "width";
    public static final String MAJOR_TICK_LABELS = "majorTicks";
    public static final String MINOR_TICKS = "minorTicks";

    public Map<String, String> getDecoratorMap() {
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(GREEN_FROM, this.getGreenFromDecorator());
        configurations.put(GREEN_TO, this.getGreenToDecorator());
        configurations.put(RED_FROM, this.getRedFromDecorator());
        configurations.put(RED_TO, this.getRedToDecorator());
        configurations.put(YELLOW_FROM, this.getYellowFromDecorator());
        configurations.put(YELLOW_TO, this.getYellowToDecorator());
        configurations.put(HEIGHT, this.getHeightDecorator());
        configurations.put(MIN, this.getMinDecorator());
        configurations.put(MAX, this.getMaxDecorator());
        configurations.put(WIDTH, this.getWidthDecorator());
        configurations.put(MAJOR_TICK_LABELS, this.getMajorTickLabelDecorator());
        configurations.put(MINOR_TICKS, this.getMinorTicksDecorator());
        return configurations;
    }
    private long greenFrom;
    private long redFrom;
    private long yellowFrom;
    private long greenTo;
    private long redTo;
    private long yellowTo;
    private long width;
    private long height;
    private long min;
    private long max;
    private long minorTicks;


    private List<String> majorTickLabels;

    public GagueDecorator() {
        majorTickLabels = new ArrayList<String>();
    }
    public void setGreenFrom(long greenFrom) {
        this.greenFrom = greenFrom;
    }    

    public void setGreenTo(long greenTo) {
        this.greenTo = greenTo;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public void setMinorTicks(long minorTicks) {
        this.minorTicks = minorTicks;
    }

    public void setRedFrom(long redFrom) {
        this.redFrom = redFrom;
    }

    public void setRedTo(long redTo) {
        this.redTo = redTo;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public void setYellowFrom(long yellowFrom) {
        this.yellowFrom = yellowFrom;
    }

    public void setYellowTo(long yellowTo) {
        this.yellowTo = yellowTo;
    }

    public String getGreenFromDecorator() {
        return ""+this.greenFrom;
    }
    public String getGreenToDecorator() {
        return ""+this.greenTo;
    }
    public String getRedFromDecorator() {
        return ""+this.redFrom;
    }
    public String getRedToDecorator() {
        return ""+this.redTo;
    }
    public String getYellowFromDecorator() {
        return ""+this.yellowFrom;
    }
    public String getYellowToDecorator() {
        return ""+this.yellowTo;
    }
    public String getMinDecorator() {
        return ""+this.min;
    }
    public String getMaxDecorator() {
        return ""+this.max;
    }
    public String getHeightDecorator() {
        return ""+this.height;
    }
    public String getWidthDecorator() {
        return ""+this.width;
    }
    public String getMinorTicksDecorator() {
        return ""+this.minorTicks;
    }

    private String getMajorTickLabelDecorator() {
        StringBuffer stopWordsDecorator = new StringBuffer();
        stopWordsDecorator.append("[");
        boolean previous = false;
        for (String word : majorTickLabels) {
            if (previous) {
                stopWordsDecorator.append(",");
            } else {
                previous = true;
            }
            stopWordsDecorator.append("'"+word+"'");
        }
        stopWordsDecorator.append("]");
        return stopWordsDecorator.toString();
    }

    public void addMajorTickLabel(String majorTickLabel) {
        this.majorTickLabels.add(majorTickLabel);
    }
    
    public <T extends Decorator>T getDefaultDecorator() {
        this.setGreenFrom(0);
        this.setGreenTo( (long) (max*(.3)) );
        this.setRedFrom( (long) (max*(.9)) );
        this.setRedTo( max );
        this.setYellowFrom((long) (max*(.6)));
        this.setYellowTo((long) (max*(.9)));
        this.setMin(0);
        this.setMax(10);
        this.setWidth(480);
        this.setHeight(240);
        this.addMajorTickLabel("0%");
        this.addMajorTickLabel("20%");
        this.addMajorTickLabel("40%");
        this.addMajorTickLabel("60%");
        this.addMajorTickLabel("80%");
        this.addMajorTickLabel("100%");
        this.setMinorTicks(5);
        return (T)this;
    }
}
