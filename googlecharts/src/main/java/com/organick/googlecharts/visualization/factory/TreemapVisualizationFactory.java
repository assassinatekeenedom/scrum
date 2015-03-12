/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.factory;

import com.organick.googlecharts.chart.impl.TreemapImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.chart.structure.TreemapNode;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class TreemapVisualizationFactory {

    /**
     * 
     * @param <T>
     * @param words
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getTreemap(List<TreemapNode> treemapNodes, Decorator decorator) {
        TreemapImpl visual = new TreemapImpl();
        visual.setDecorations(decorator);        
        for (TreemapNode node : treemapNodes) {
            visual.addEntry(node.getSelf(), node.getParent(), node.getSize(), node.getScale());
        }
        return (T) visual;
    }
}
