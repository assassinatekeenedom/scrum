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
public class PieChartDecorator extends VisualizationDecoratorImpl {

    public static final String TITLE = "title";
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String CHART_AREA = "chartArea";
    public static final String IS_3D = "is3D";
    public static final String COLORS = "colors";
    public static final String HEIGHT = "height";
    public static final String WIDTH = "width";
    public static final String LEGEND = "legend";
    public static final String PIE_SLICE_TEXT = "pieSliceText";
    public static final String PIE_SLICE_TEXT_STYLE = "pieSliceTextStyle";
    public static final String LEGEND_TEXT_STYLE = "legendTextStyle";
    public static final String TITLE_TEXT_STYLE = "titleTextStyle";
    public static final String TOOLTIP_TEXT_STYLE = "tooltipTextStyle";

    public Map<String, String> getDecoratorMap() {
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(TITLE, this.getTitleDecorator());
        configurations.put(BACKGROUND_COLOR, this.getBackgroundColorDecorator());
        configurations.put(CHART_AREA, this.getChartAreaDecorator());
        configurations.put(COLORS, this.getSliceColorsDecorator());
        configurations.put(HEIGHT, this.getHeightDecorator());
        configurations.put(WIDTH, this.getWidthDecorator());
        configurations.put(IS_3D, this.getIs3DDecorator());
        configurations.put(LEGEND, this.getLegendPositionDecorator());
        configurations.put(LEGEND_TEXT_STYLE, this.getLegendTextStyleDecorator());
        configurations.put(PIE_SLICE_TEXT_STYLE, this.getSliceTextStyleDecorator());
        configurations.put(TITLE_TEXT_STYLE, this.getTitleTextStyleDecorator());
        configurations.put(TOOLTIP_TEXT_STYLE, this.getTooltipTextStyleDecorator());
        configurations.put(PIE_SLICE_TEXT, this.getSliceLabelTypeDecorator());
        return configurations;
    }
    private String title;
    private String backgroundColor;
    private List<String> sliceColors;
    private String sliceLabelType;
    private String legendPosition;
    private int legendTextSize;
    private String legendTextColor;
    private String legendTextFont;
    private int sliceTextSize;
    private String sliceTextColor;
    private String sliceTextFont;
    private int titleTextSize;
    private String titleTextColor;
    private String titleTextFont;
    private int tooltipTextSize;
    private String tooltipTextColor;
    private String tooltipTextFont;
    private int totalHeight;
    private int totalWidth;
    private int chartAreaLeft;
    private int chartAreaTop;
    private int chartAreaWidth;
    private int chartAreaHeight;
    private boolean is3D;

    public PieChartDecorator() {
    }

    public boolean setTitle(String title) {
        try {
            this.title = title;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setSliceColors(List<String> sliceColors) {
        try {
            this.sliceColors = sliceColors;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setSliceLabelType(String option) {
        try {
            if ("percentage".equals(option)) {
                this.sliceLabelType = option;
                return true;
            } else if ("value".equals(option)) {
                this.sliceLabelType = option;
                return true;
            } else if ("label".equals(option)) {
                this.sliceLabelType = option;
                return true;
            } else {
                this.sliceLabelType = "none";
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setLegendPosition(String position) {
        try {
            if ("left".equals(position)) {
                this.legendPosition = position;
                return true;
            } else if ("right".equals(position)) {
                this.legendPosition = position;
                return true;
            } else if ("top".equals(position)) {
                this.legendPosition = position;
                return true;
            } else if ("bottom".equals(position)) {
                this.legendPosition = position;
                return true;
            } else {
                this.legendPosition = "none";
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setLegendTextStyle(String fontColor, String fontName, int fontSize) {
        try {
            this.legendTextColor = fontColor;
            this.legendTextFont = fontName;
            this.legendTextSize = fontSize;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setSliceTextStyle(String fontColor, String fontName, int fontSize) {
        try {
            this.sliceTextColor = fontColor;
            this.sliceTextFont = fontName;
            this.sliceTextSize = fontSize;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setTitleTextStyle(String fontColor, String fontName, int fontSize) {
        try {
            this.titleTextColor = fontColor;
            this.titleTextFont = fontName;
            this.titleTextSize = fontSize;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setTooltipTextStyle(String fontColor, String fontName, int fontSize) {
        try {
            this.tooltipTextColor = fontColor;
            this.tooltipTextFont = fontName;
            this.tooltipTextSize = fontSize;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setTotalHeight(int height) {
        try {
            this.totalHeight = height;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setTotalWidth(int width) {
        try {
            this.totalWidth = width;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setChartSizingInfo(int left, int top, int width, int height) {
        try {
            this.chartAreaLeft = left;
            this.chartAreaTop = top;
            this.chartAreaWidth = width;
            this.chartAreaHeight = height;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setBackgroundColor(String color) {
        try {
            this.backgroundColor = "'" + color + "'";
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setIs3D(boolean is3D) {
        this.is3D = is3D;
        return true;
    }

    private String getBackgroundColorDecorator() {
        if (this.backgroundColor == null) {
            this.backgroundColor = "'white'";
        }
        return this.backgroundColor;
    }

    private String getChartAreaDecorator() {
        if (this.chartAreaLeft < 1) {
            this.chartAreaLeft = 0;
        }
        if (this.chartAreaTop < 1) {
            this.chartAreaTop = 0;
        }
        if (this.chartAreaHeight < 1) {
            this.chartAreaHeight = 300;
        }
        if (this.chartAreaWidth < 1) {
            this.chartAreaWidth = 450;
        }
        return "{left:" + this.chartAreaLeft + ",top:" + this.chartAreaTop + ",width:" + this.chartAreaWidth + ",height:" + this.chartAreaHeight + "}";
    }

    private String getSliceColorsDecorator() {
        if (this.sliceColors == null || this.sliceColors.size() < 1) {
            this.sliceColors = PieChartDecorator.getDefaultColors();
        }
        StringBuffer colorDecorator = new StringBuffer();
        colorDecorator.append("[");
        boolean previous = false;
        for (String color : sliceColors) {
            if (previous) {
                colorDecorator.append(",");
            } else {
                previous = true;
            }
            colorDecorator.append("'" + color + "'");
        }
        colorDecorator.append("]");
        return colorDecorator.toString();
    }

    private String getHeightDecorator() {
        if (this.totalHeight < 1) {
            this.totalHeight = 300;
        }
        return "" + totalHeight;
    }

    private String getWidthDecorator() {
        if (this.totalWidth < 1) {
            this.totalWidth = 450;
        }
        return "" + totalWidth;
    }

    private String getIs3DDecorator() {
        return "" + this.is3D;
    }

    private String getLegendPositionDecorator() {
        return "'" + this.legendPosition + "'";
    }

    private String getTitleDecorator() {
        return "'" + this.title + "'";
    }

    private String getSliceLabelTypeDecorator() {
        return "'" + this.sliceLabelType + "'";
    }

    private String getLegendTextStyleDecorator() {
        StringBuffer legendStyle = new StringBuffer();
        legendStyle.append("{color:'");
        if (this.legendTextColor == null) {
            this.legendTextColor = "black";
        }
        legendStyle.append(this.legendTextColor);
        legendStyle.append("',fontName:'");
        if (this.legendTextFont == null) {
            this.legendTextFont = "arial";
        }
        legendStyle.append(this.legendTextFont);
        legendStyle.append("',fontSize:");
        if (this.legendTextSize < 1) {
            this.legendTextSize = 12;
        }
        legendStyle.append(Integer.toString(this.legendTextSize));
        legendStyle.append("}");
        return legendStyle.toString();
    }

    private String getSliceTextStyleDecorator() {
        StringBuffer sliceStyle = new StringBuffer();
        sliceStyle.append("{color:'");
        if (this.sliceTextColor == null) {
            this.sliceTextColor = "black";
        }
        sliceStyle.append(this.sliceTextColor);
        sliceStyle.append("',fontName:'");
        if (this.sliceTextFont == null) {
            this.sliceTextFont = "arial";
        }
        sliceStyle.append(this.sliceTextFont);
        sliceStyle.append("',fontSize:");
        if (this.sliceTextSize < 1) {
            this.sliceTextSize = 12;
        }
        sliceStyle.append(Integer.toString(this.sliceTextSize));
        sliceStyle.append("}");
        return sliceStyle.toString();
    }

    private String getTitleTextStyleDecorator() {
        StringBuffer titleStyle = new StringBuffer();
        titleStyle.append("{color:'");
        if (this.titleTextColor == null) {
            this.titleTextColor = "black";
        }
        titleStyle.append(this.titleTextColor);
        titleStyle.append("',fontName:'");
        if (this.titleTextFont == null) {
            this.titleTextFont = "arial";
        }
        titleStyle.append(this.titleTextFont);
        titleStyle.append("',fontSize:");
        if (this.titleTextSize < 1) {
            this.titleTextSize = 12;
        }
        titleStyle.append(Integer.toString(this.titleTextSize));
        titleStyle.append("}");
        return titleStyle.toString();
    }

    private String getTooltipTextStyleDecorator() {
        StringBuffer tooltipStyle = new StringBuffer();
        tooltipStyle.append("{color:'");
        if (this.tooltipTextColor == null) {
            this.tooltipTextColor = "black";
        }
        tooltipStyle.append(this.tooltipTextColor);
        tooltipStyle.append("',fontName:'");
        if (this.tooltipTextFont == null) {
            this.tooltipTextFont = "arial";
        }
        tooltipStyle.append(this.tooltipTextFont);
        tooltipStyle.append("',fontSize:");
        if (this.tooltipTextSize < 1) {
            this.tooltipTextSize = 12;
        }
        tooltipStyle.append(Integer.toString(this.tooltipTextSize));
        tooltipStyle.append("}");
        return tooltipStyle.toString();
    }

    public static List<String> getDefaultColors() {
        List<String> sliceColors = new ArrayList<String>();
        sliceColors.add("blue");
        sliceColors.add("green");
        sliceColors.add("orange");
        sliceColors.add("brown");
        sliceColors.add("purple");
        sliceColors.add("yellow");
        sliceColors.add("black");
        sliceColors.add("red");
        sliceColors.add("gray");
        sliceColors.add("yellowgreen");
        sliceColors.add("aqua");
        sliceColors.add("khaki");
        sliceColors.add("lighblue");
        sliceColors.add("thisle");
        return sliceColors;

    }

    public <T extends Decorator>T getDefaultDecorator() {
        this.setTitle("Pie Chart");
        this.setBackgroundColor("white");
        this.setChartSizingInfo(20, 80, 400, 550);
        this.setIs3D(true);
        this.setSliceColors(PieChartDecorator.getDefaultColors());
        this.setTotalHeight(300);
        this.setTotalWidth(450);
        this.setLegendPosition("top");
        this.setSliceLabelType("value");
        this.setSliceTextStyle("white", "arial", 16);
        this.setLegendTextStyle("black", "arial", 16);
        this.setTitleTextStyle("black", "arial", 16);
        this.setTooltipTextStyle("black", "arial", 18);
        return (T)this;
    }
}
