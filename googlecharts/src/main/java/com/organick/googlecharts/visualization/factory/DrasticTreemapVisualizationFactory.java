/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.factory;

import com.organick.googlecharts.chart.impl.DrasticTreemapImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.chart.structure.TreemapNode;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nkeene
 */
public class DrasticTreemapVisualizationFactory {

    /**
     * 
     * @param <T>
     * @param words
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getDrasticTreemap(List<String> searches, Map<String, List<TreemapNode>> treemapNodeMap, Decorator decorator) {
        DrasticTreemapImpl visual = new DrasticTreemapImpl(searches);
        visual.setDecorations(decorator);
        for (String search : searches) {
            List<TreemapNode> treemapNodes = treemapNodeMap.get(search);
            for (TreemapNode node : treemapNodes) {
                visual.addEntry(node.getSelf(), node.getParent(), node.getSize());
            }
        }
        return (T) visual;
    }
}
