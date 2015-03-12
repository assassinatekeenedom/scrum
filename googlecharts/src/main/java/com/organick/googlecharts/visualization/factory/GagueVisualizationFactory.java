/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.visualization.factory;



import com.organick.googlecharts.chart.impl.GagueImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class GagueVisualizationFactory {

    /**
     * 
     * @param <T>
     * @param words
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getGague(List<String> labels, List<Long> values, Decorator decorator) {
        GagueImpl visual = new GagueImpl();
        visual.setDecorations(decorator);
        for(int x=0; x<labels.size(); x++){
            String label = (String)labels.get(x);
            long value = (Long)values.get(x);
            visual.addGague(label, value);
        }
        return (T) visual;
    }

}
