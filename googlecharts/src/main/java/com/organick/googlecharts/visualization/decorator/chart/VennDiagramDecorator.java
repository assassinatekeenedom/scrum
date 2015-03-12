/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.chart;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.impl.BasicDecoratorImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nkeene
 */
public class VennDiagramDecorator extends BasicDecoratorImpl {

    public static final String CHART_TYPE = "cht";
    public static final String CHART_DATA = "chd";
    public static final String CHART_TITLE = "chtt";
    public static final String CHART_INFO = "chts";
    public static final String CHART_SIZE = "chs";
    public static final String CHART_COLOR = "chco";
    public static final String CHART_LEGEND = "chdl";

    public Map<String, String> getDecoratorMap() {        
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(CHART_TITLE, this.getChartTitleDecorator());
        configurations.put(CHART_TYPE, this.getChartTypeDecorator());
        configurations.put(CHART_DATA, this.getChartDataDecorator());
        configurations.put(CHART_INFO, this.getChartInfoDecorator());
        configurations.put(CHART_COLOR, this.getChartColorDecorator());
        configurations.put(CHART_LEGEND, this.getChartLegendDecorator());
        configurations.put(CHART_SIZE, this.getChartSizeDecorator());
        return configurations;
    }
    private String chartTitle;
    private String titleColor;
    private int titleSize;
    private int chartSize;
    private List<String> chartColors;
    private List<String> chartLegend;
    private List<Long> chartData;
    private final String chartType = "v";

    public VennDiagramDecorator() {
        chartColors = new ArrayList<String>();
        chartLegend = new ArrayList<String>();
        chartData = new ArrayList<Long>();
    }

    private String getChartTypeDecorator() {
        return this.chartType;
    }

    public String getChartTitle() {
        return chartTitle;
    }

    private String getChartSizeDecorator() {
        return "" + chartSize + "x" + chartSize;
    }

    public void setChartSize(int chartSize) {
        this.chartSize = chartSize;
    }

    public void setChartTitle(String chartTitle) {
        this.chartTitle = chartTitle;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
    }

    private String getChartTitleDecorator() {
        StringBuffer aChartTitle = new StringBuffer();
        String newTitle = this.chartTitle.replaceAll(" ", "+");
        newTitle = newTitle.replaceAll("\n", "|");
        aChartTitle.append(newTitle);
        return aChartTitle.toString();
    }

    private String getChartInfoDecorator() {
        StringBuffer aChartTitle = new StringBuffer();
        aChartTitle.append(this.titleColor + "," + this.titleSize);
        return aChartTitle.toString();
    }

    private String getChartColorDecorator() {
        StringBuffer aColor = new StringBuffer();
        boolean previous = false;
        for (String color : chartColors) {
            if (!"".equals(color)) {
                if (previous) {
                    aColor.append(",");
                } else {
                    previous = true;
                }
                aColor.append(color);
            }
        }
        return aColor.toString();
    }

    private String getChartLegendDecorator() {
        StringBuffer entry = new StringBuffer();
        boolean previous = false;
        for (String anEntry : chartLegend) {
            if (!"".equals(anEntry)) {
                if (previous) {
                    entry.append("|");
                } else {
                    previous = true;
                }
                entry.append(anEntry);
            }
        }
        return entry.toString();
    }

    private String getChartDataDecorator() {
        StringBuffer entry = new StringBuffer();
        boolean previous = false;
        for (Long anEntry : chartData) {
            if (previous) {
                entry.append(",");
            } else {
                entry.append("t:");
                previous = true;
            }
            entry.append(anEntry);
        }
        return entry.toString();
    }

    public void addSphereColor(String color) {        
        this.chartColors.add(color);
    }

    public void addSphereName(String legend) {
        this.chartLegend.add(legend);
    }

    public void addSphereData(Long data) {
        this.chartData.add(data);
    }
    public <T extends Decorator>T getDefaultDecorator() {
        this.setChartTitle("Venn Diagram");
        this.setChartSize(250);
        this.setTitleColor("000000");
        this.setTitleSize(20);
        return (T)this;
    }
}
