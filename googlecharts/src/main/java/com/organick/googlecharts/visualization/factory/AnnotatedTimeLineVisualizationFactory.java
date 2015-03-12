/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.factory;

import com.organick.googlecharts.chart.impl.AnnotatedTimeLineImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.chart.structure.TimeLineData;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class AnnotatedTimeLineVisualizationFactory {

    /**
     *
     * @param <T>
     * @param labelValueMap
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getAnnotatedTimeLine(List<String> datasets, List<TimeLineData> timeLineData, Decorator decorator) {
        AnnotatedTimeLineImpl visual = new AnnotatedTimeLineImpl(datasets);
        visual.setDecorations(decorator);
        for(TimeLineData data : timeLineData){
            visual.addEvent(data.getDate(), data.getValues(), data.getLabels(), data.getDetails());
        }
        return (T) visual;
    }
}
