/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.factory;

import com.organick.googlecharts.chart.impl.PieChartImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class PieChartVisualizationFactory {

    /**
     *
     * @param <T>
     * @param labelValueMap
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getPieChart(List<String> labels, List<Object> values, Decorator decorator) {
        PieChartImpl visual = new PieChartImpl();
        visual.setDecorations(decorator);
        if (labels != null && values != null) {
            if (labels.size() == values.size()) {
                for (int x = 0; x < labels.size(); x++) {
                    String label = labels.get(x);
                    Object value = values.get(x);
                    if ("java.lang.Long".equals(value.getClass().getName())) {
                        visual.addData((String) label, (Long) value);
                    } else if ("java.lang.Integer".equals(value.getClass().getName())) {
                        visual.addData((String) label, (Integer) value);
                    } else if ("java.lang.Double".equals(value.getClass().getName())) {
                        visual.addData((String) label, (Double) value);
                    } else if ("java.lang.Float".equals(value.getClass().getName())) {
                        visual.addData((String) label, (Float) value);
                    } else {
                        System.out.println("!= " + value.getClass().getName());
                    }
                }
            }
        }
        return (T) visual;
    }
}
